package cn.dhx.juc.juc.tool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author daihongxin
 * @create 2023/6/3 1:28
 */
@Slf4j
public class ReentrantReadWriteLockDemo {

    DataContainer dataContainer = new DataContainer();

    @Test
    public void readAndRead() throws InterruptedException {

        new Thread(() -> {
            dataContainer.read();
        }).start();

        new Thread(() -> {
            dataContainer.read();
        }).start();

        TimeUnit.SECONDS.sleep(10);
    }


    @Test
    public void readAndWriter() throws InterruptedException {

        new Thread(() -> {
            dataContainer.read();
        }).start();

        new Thread(() -> {
            dataContainer.write();
        }).start();

        TimeUnit.SECONDS.sleep(10);
    }


    @Test
    public void WriterAndWriter() throws InterruptedException {

        new Thread(() -> {
            dataContainer.write();
        }).start();

        new Thread(() -> {
            dataContainer.write();
        }).start();

        TimeUnit.SECONDS.sleep(10);
    }

}



@Slf4j
class DataContainer {

    private Object data;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = rw.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rw.writeLock();

    public Object read() {
        log.info("获取读锁");
        readLock.lock();
        try {
            log.info("读取");
            TimeUnit.SECONDS.sleep(1);
            return data;
        } catch (Exception e) {
            log.error("");
            return data;
        } finally {
            readLock.unlock();
        }
    }

    public void write() {
        log.error("获取写锁");
        writeLock.lock();
        try {
            log.info("写入");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

    }
}
