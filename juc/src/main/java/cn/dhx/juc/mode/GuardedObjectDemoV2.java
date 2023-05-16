package cn.dhx.juc.mode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/14 13:51
 */
@Slf4j
public class GuardedObjectDemoV2 {

    public static void main(String[] args) {
        GuardedObjectV2 guardedObjectV2 = new GuardedObjectV2();

        new Thread(()->{
            log.info("waiting----");
            Object o = guardedObjectV2.get(6000);
            log.info("response {}", o);
        }).start();

        new Thread(() -> {
            log.info("start");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String str = "done result";
            guardedObjectV2.complete(str);

        }).start();




    }
}

@Slf4j
class GuardedObjectV2 {

    private Object response;
    private final Object lock = new Object();

    public Object get(long timeout) {
        synchronized (lock) {
            long begin = System.currentTimeMillis();
            long timePassed = 0;//已经经历的时间
            while (response == null) {

                //处理虚假唤醒的时间
                long waitTime = timeout - timePassed;
                if (waitTime <= 0) {
                    log.info("break");
                    break;
                }


                try {
                    lock.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                timePassed = System.currentTimeMillis() - begin;
                log.info("timePassed {},response is  {}", timePassed, response);
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (lock) {
            this.response = response;
            log.info("notify");
            lock.notifyAll();
        }
    }

}
