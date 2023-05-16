package cn.dhx.juc.mode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/14 13:51
 * 保护性暂停
 * 即 Guarded Suspension，用在一个线程等待另一个线程的执行结果
 * 要点
 * 有一个结果需要从一个线程传递到另一个线程，让他们关联同一个 GuardedObject
 * 如果有结果不断从一个线程到另一个线程那么可以使用消息队列（见生产者/消费者）
 * JDK 中，join 的实现、Future 的实现，采用的就是此模式
 * 因为要等待另一方的结果，因此归类到同步模式
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
