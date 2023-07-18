package cn.dhx.boot.delayqueue.jvm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.DelayQueue;

/**
 * @Author daihongxin
 * @create 2023/7/17 10:06
 */
@Slf4j
@Service
public class OrderDelayService {


    @Autowired
    private DelayQueue<OrderDelayObject> orderDelayQueue;

    public void addObject() {
        //发起订单下单的时候将订单演示对象放入orderDelayQueue
        OrderDelayObject orderDelayObject = new OrderDelayObject(1L, 30*1000, "延时任务订单对象信息");
        orderDelayQueue.add(orderDelayObject);
        log.info("orderDelayObject add {}", orderDelayObject.toString());
    }


}
