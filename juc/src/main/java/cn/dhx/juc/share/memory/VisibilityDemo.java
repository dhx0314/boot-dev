package cn.dhx.juc.share.memory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/17 0:18
 * 可见性
 */
@Slf4j
public class VisibilityDemo {


    static boolean run = true;
    static volatile boolean volatileRun=true;

    @Test
    public void errorDemo() throws InterruptedException {
        log.info("start");
        Thread thread = new Thread(() -> {
            while (run) {
                //
            }
        });
        thread.start();


        TimeUnit.SECONDS.sleep(1);
        run=false;
        thread.join();
        log.info("end");
    }

    @Test
    public void tureDemo() throws InterruptedException {
        log.info("start");
        Thread thread = new Thread(() -> {
            while (volatileRun) {
                //
            }
        });
        thread.start();


        TimeUnit.SECONDS.sleep(1);
        volatileRun=false;
        thread.join();
        log.info("end");
    }


}
