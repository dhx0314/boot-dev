package cn.dhx.juc.mode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author daihongxin
 * 交替打印
 * @create 2023/5/16 22:50
 */
@Slf4j
public class alternatelyOutput2 {

    public static void main(String[] args) throws InterruptedException {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        new Thread(()->{
            awaitSignal.print("aa",a,b);
        }).start();
        new Thread(()->{
            awaitSignal.print("bb",b,c);
        }).start();
        new Thread(()->{
            awaitSignal.print("cc",c,a);
        }).start();
        TimeUnit.SECONDS.sleep(1);
        awaitSignal.start(a);
        TimeUnit.SECONDS.sleep(10);
    }
}

@Slf4j
class AwaitSignal extends ReentrantLock {

    private int loopNumber;

    public AwaitSignal(int loopNumber) {
       this.loopNumber = loopNumber;
    }

    public void start(Condition first) {
        this.lock();
        try {
            log.info("start");
            first.signal();
        } finally {
            this.unlock();
        }
    }

    public void print(String str,Condition current,Condition next)  {
        for (int i = 0; i < loopNumber; i++) {
            this.lock();
            try {
                current.await();
                log.info("message {}", str);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                this.unlock();
            }
        }
    }
}
