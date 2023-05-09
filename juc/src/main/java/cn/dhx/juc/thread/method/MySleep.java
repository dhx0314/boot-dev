package cn.dhx.juc.thread.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


@Slf4j
public class MySleep {

    @Test
    public void sleep() throws InterruptedException {

        Thread thread = new Thread(() -> {
            log.info("start sleep");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                log.info("interrupted");
                e.printStackTrace();
            }
            log.info("end run");
        });
        thread.start();
        String state0 = thread.getState().toString();
        log.info("state0 {}", state0);

        TimeUnit.SECONDS.sleep(1);
        String state1 = thread.getState().toString();
        log.info("state1 {}", state1);

        thread.interrupt();

        String state2 = thread.getState().toString();
        log.info("state2 {}", state2);
    }


}
//20:21:02.803 [main] INFO cn.dhx.juc.thread.method.MySleep - state0 RUNNABLE
//20:21:02.803 [Thread-0] INFO cn.dhx.juc.thread.method.MySleep - start sleep
//20:21:03.814 [main] INFO cn.dhx.juc.thread.method.MySleep - state1 TIMED_WAITING
//20:21:03.814 [main] INFO cn.dhx.juc.thread.method.MySleep - state2 TIMED_WAITING
//20:21:03.814 [Thread-0] INFO cn.dhx.juc.thread.method.MySleep - interrupted
//java.lang.InterruptedException: sleep interrupted
//	at java.lang.Thread.sleep(Native Method)
//	at java.lang.Thread.sleep(Thread.java:340)
//	at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
//	at cn.dhx.juc.thread.method.MySleep.lambda$sleep$0(MySleep.java:18)