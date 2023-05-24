package cn.dhx.juc.share.monitor.synchronize.lock;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author daihongxin
 * @create 2023/5/13 13:32
 * 批量撤销
 */
@Slf4j
public class BatchRevocation {

    static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) throws InterruptedException {
        batchRevocation();

    }

    //-XX:BiasedLockingStartupDelay=0
    public static void batchRevocation() throws InterruptedException {
//        log.info("lock {}", ClassLayout.parseInstance(new Dog()).toPrintable());
        CopyOnWriteArrayList<Dog> list = new CopyOnWriteArrayList<>();
        int loopNumber = 39;
        t1 = new Thread(() -> {
            for (int i = 0; i < loopNumber; i++) {
                Dog d = new Dog();
                list.add(d);
                synchronized (d) {
                    log.info("i {} lock stage {}", i, MyClassLayout.printMarkDown(d));
                }
            }
            LockSupport.unpark(t2);
        });
        t1.start();

        t2 = new Thread(() -> {
            LockSupport.park();
            log.info("t2----------------->");
            for (int i = 0; i < loopNumber; i++) {
                Dog d = list.get(i);
                log.info("i {} start {}", i, MyClassLayout.printMarkDown(d));
                synchronized (d) {
                    log.info("i {} lock in {}", i, MyClassLayout.printMarkDown(d));
                }
                log.info("i {} end {}", i, MyClassLayout.printMarkDown(d));
            }
            LockSupport.unpark(t3);
        });
        t2.start();

        t3 = new Thread(() -> {
            LockSupport.park();
            log.info("t3----------------->");
            for (int i = 0; i < loopNumber; i++) {
                Dog d = list.get(i);
                log.info("i {} start {}", i, MyClassLayout.printMarkDown(d));
                synchronized (d) {
                    log.info("i {} lock in {}", i, MyClassLayout.printMarkDown(d));
                }
                log.info("i {} end {}", i, MyClassLayout.printMarkDown(d));
            }
            LockSupport.unpark(t3);
        });
        t3.start();

        t3.join();
        log.info("lock {}", ClassLayout.parseInstance(new Dog()).toPrintable());
    }
}
