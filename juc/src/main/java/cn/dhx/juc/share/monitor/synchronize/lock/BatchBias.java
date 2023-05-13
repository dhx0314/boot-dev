package cn.dhx.juc.share.monitor.synchronize.lock;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author daihongxin
 * @create 2023/5/13 11:48
 * 批量重偏向
 */
@Slf4j
public class BatchBias {


    public static void main(String[] args) throws InterruptedException {
        batchBias();
    }

    //-XX:BiasedLockingStartupDelay=0
    public static void batchBias() throws InterruptedException {
        CopyOnWriteArrayList<Dog> list = new CopyOnWriteArrayList<>();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                Dog d = new Dog();
                list.add(d);
                synchronized (d) {
                    log.info("i {} lock stage {}", i, ClassLayout.parseInstance(d).toPrintable());
                }
            }

            synchronized (list) {
                list.notifyAll();
            }
        });
        thread.start();

        Thread thread1 = new Thread(() -> {
            synchronized (list) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < 30; i++) {
                Dog d = list.get(i);
                log.info("i {} start {}", i, ClassLayout.parseInstance(d).toPrintable());
                synchronized (d) {
                    log.info("i {} lock in {}", i, ClassLayout.parseInstance(d).toPrintable());
                }
                log.info("i {} end {}", i, ClassLayout.parseInstance(d).toPrintable());

            }
        });
        thread1.start();
        thread1.join();
    }
}
