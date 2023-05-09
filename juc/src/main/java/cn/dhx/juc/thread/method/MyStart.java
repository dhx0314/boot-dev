package cn.dhx.juc.thread.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class MyStart {

    @Test
    public void start() {
        Thread thread = new Thread(() -> {
            log.info("start");
        });
        thread.start();
        thread.start();

        thread.setPriority(Thread.MAX_PRIORITY);

    }
}

//20:20:37.949 [Thread-0] INFO cn.dhx.juc.thread.method.MyStart - start
//
//java.lang.IllegalThreadStateException
//	at java.lang.Thread.start(Thread.java:708)
//	at cn.dhx.juc.thread.method.MyStart.start(MyStart.java:16)
