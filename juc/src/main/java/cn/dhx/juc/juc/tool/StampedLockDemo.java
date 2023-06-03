package cn.dhx.juc.juc.tool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @Author daihongxin
 * @create 2023/6/3 16:29
 */
@Slf4j
public class StampedLockDemo {

    DataContainerStamped dataContainerStamped = new DataContainerStamped();

    @Test
    public void readAndRead() throws InterruptedException {
        new Thread(() -> {
            dataContainerStamped.read(0);
        }).start();

        new Thread(() -> {
            dataContainerStamped.read(2);
        }).start();

        TimeUnit.SECONDS.sleep(10);

    }


    @Test
    public void readAndWrite() throws InterruptedException {
        new Thread(() -> {
            dataContainerStamped.read(3);
        }).start();

        new Thread(() -> {
            dataContainerStamped.writer(100);
        }).start();

        TimeUnit.SECONDS.sleep(10);

    }

}


@Slf4j
class DataContainerStamped {

    private int data;

    private StampedLock lock = new StampedLock();

    public int read(int readTime) {
        long stamp = lock.tryOptimisticRead();
        log.info("tryOptimisticRead locking {}", stamp);
        try {
            TimeUnit.SECONDS.sleep(readTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (lock.validate(stamp)) {
            log.info("read finish {} data {}", stamp, data);
            return data;
        }

        log.info("updating to read lock {}", stamp);
        try {
            stamp = lock.readLock();
            log.info("read lock {}", stamp);
            TimeUnit.SECONDS.sleep(readTime);
            log.info("read finish {} data {}", stamp, data);
            return data;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return data;
        } finally {
            log.info("read unlock {}", stamp);
            lock.unlockRead(stamp);
        }
    }


    public void writer(int newData) {
        long stamp = lock.writeLock();
        log.info("write lock {}", stamp);
        try {
            TimeUnit.SECONDS.sleep(2);
            this.data = newData;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info("write unlock {}", stamp);
            lock.unlockWrite(stamp);
        }

    }


}
