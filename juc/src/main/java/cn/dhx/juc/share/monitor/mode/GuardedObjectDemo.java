package cn.dhx.juc.share.monitor.mode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/14 13:51
 * 保护性暂停
 */
@Slf4j
public class GuardedObjectDemo {

    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();

        new Thread(()->{
            log.info("waiting----");
            Object o = guardedObject.get();
            log.info("response {}",o);
        }).start();
        new Thread(() -> {
            log.info("start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String str = "done result";
            guardedObject.complete(str);

        }).start();


    }
}

@Slf4j
class GuardedObject{

    private Object response;
    private final Object lock = new Object();


    public Object get() {
        synchronized (lock) {
            while (response == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
