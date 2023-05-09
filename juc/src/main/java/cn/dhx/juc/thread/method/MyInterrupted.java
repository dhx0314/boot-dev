package cn.dhx.juc.thread.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;


@Slf4j
public class MyInterrupted {

    @Test
    public void interrupted1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("thread sleep");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        log.info("state {}", thread.isInterrupted());
    }


    @Test
    public void interrupted2() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("thread sleep");
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.info("interrupted");
                    break;
                }
            }

        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        log.info("start interrupt");
        thread.interrupt();
        log.info("state {}", thread.isInterrupted());
    }

    @Test
    public void interrupted3() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("thread park");
            LockSupport.park();
            log.info("thread unpark");
            log.info("state {}", Thread.currentThread().isInterrupted());

            LockSupport.park();
            log.info("thread park");

        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        log.info("start interrupt");
        thread.interrupt();
        log.info("state {}", thread.isInterrupted());

        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    public void interrupted4() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("thread park");
            LockSupport.park();
            log.info("thread unpark");
            log.info("state {}", Thread.interrupted());

            LockSupport.park();
            log.info("thread park");

        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        log.info("start interrupt");
        thread.interrupt();
        log.info("state {}", thread.isInterrupted());

        TimeUnit.SECONDS.sleep(10);
    }
}
