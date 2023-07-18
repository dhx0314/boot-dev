package cn.dhx.boot.delayqueue.zset;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * @Author daihongxin
 * @create 2023/7/17 10:31
 */
@Slf4j
@Service("ZSetOrderDelayService")
public class OrderDelayService   {
    //redis zset key
    public static final String ORDER_DELAY_TASK_KEY = "delaytask:order";

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    //生成订单-order为订单信息，可以是订单流水号，用于延时任务达到时效后关闭订单
    public void produce(String orderSerialNo){
        stringRedisTemplate.opsForZSet().add(
                ORDER_DELAY_TASK_KEY,     // redis key
                orderSerialNo,    // zset  member
                //30分钟延时
                System.currentTimeMillis() + (30  * 1000)    //zset score
        );
        log.info("add zset orderSerialNo {}",orderSerialNo);
    }


    public void consuming(){


        try {

            Set<ZSetOperations.TypedTuple<String>> orderSerialNos = stringRedisTemplate.opsForZSet().rangeByScoreWithScores(
                    ORDER_DELAY_TASK_KEY,
                    0,
                    System.currentTimeMillis()
            );





//            log.info("orderSerialNos {}", orderSerialNos);
            if (!CollectionUtils.isEmpty(orderSerialNos)) {
                for (ZSetOperations.TypedTuple<String> orderSerialNo : orderSerialNos) {
                    //这里根据orderSerialNo去检查用户是否完成了订单支付
                    //如果用户没有支付订单，去执行订单关闭的操作
                    log.info("订单" + orderSerialNo.getValue() + "超时被自动关闭");
                    //订单关闭之后，将订单延时任务从队列中删除
                    stringRedisTemplate.opsForZSet().remove(ORDER_DELAY_TASK_KEY, orderSerialNo.getValue());
                }
            }
        } catch (Exception e) {
            log.error("consuming ",e);
        }
    }

    //该类对象Bean实例化之后，就开启while扫描任务
    @PostConstruct
    public void run()  {
        new Thread(() -> {  //开启新的线程，否则SpringBoot应用初始化无法启动
            while(true){

                consuming();
                try {
                    Thread.sleep(1 * 1000);   //每5秒扫描一次redis库获取延时数据，不用太频繁没必要
                } catch (InterruptedException e) {
                    e.printStackTrace();  //本文只是示例，生产环境请做好相关的异常处理
                }
            }
        }).start();
    }
}
