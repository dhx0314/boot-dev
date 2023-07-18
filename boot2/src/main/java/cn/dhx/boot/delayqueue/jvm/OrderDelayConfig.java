package cn.dhx.boot.delayqueue.jvm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.DelayQueue;

/**
 * @Author daihongxin
 * @create 2023/7/17 10:04
 */
@Slf4j
@Configuration
public class OrderDelayConfig {



    //https://mp.weixin.qq.com/s?__biz=MzU0NDU5MTk1MQ==&mid=2247485724&idx=1&sn=06db8cbc2a5663b57ea92e8637ee50f7&chksm=fb78903ccc0f192aeab24c97652c5a6e47f54b5f155efe5aedb27e7f9c60f3d2a5e8bfa561f5&scene=178&cur_album_id=2540840147119046657#rd

    //使用DelayQueue实现延时任务非常简单，而且简便，全部都是标准的JDK代码实现，
    // 不用引入第三方依赖（不依赖redis实现、消息队列实现等），非常的轻量级。
    //
    //它的缺点就是所有的操作都是基于应用内存的，一旦出现应用单点故障，可能会造成延时任务数据的丢失。
    // 如果订单并发量非常大，因为DelayQueue是无界的，订单量越大，队列内的对象就越多，可能造成OOM的风险。
    // 所以使用DelayQueue实现延时任务，只适用于任务量较小的情况
    @Bean("orderDelayQueue")
    public DelayQueue<OrderDelayObject> orderDelayQueue(){
        return new DelayQueue<OrderDelayObject>();
    }
}
