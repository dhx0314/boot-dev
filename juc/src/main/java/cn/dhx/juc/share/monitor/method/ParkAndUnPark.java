package cn.dhx.juc.share.monitor.method;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author daihongxin
 * @create 2023/5/14 21:24
 */
@Slf4j
public class ParkAndUnPark {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            log.info("start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("park");
            LockSupport.park();
            log.info("resume");
        },"t1");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("unPark");
        LockSupport.unpark(thread);
    }
}
