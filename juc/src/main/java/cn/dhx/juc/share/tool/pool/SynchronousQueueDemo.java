package cn.dhx.juc.share.tool.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/31 16:48
 */
@Slf4j
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                log.info("putting {}", 1);
                synchronousQueue.put(1);
                log.info("putted {}", 1);

                log.info("putting {}", 2);
                synchronousQueue.put(2);
                log.info("putted {}", 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            try {
                log.info("taking {}", 1);
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
