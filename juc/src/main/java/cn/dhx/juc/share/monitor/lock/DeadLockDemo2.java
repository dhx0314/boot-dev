package cn.dhx.juc.share.monitor.lock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


/**
 * @Author daihongxin
 * @create 2023/5/16 14:33
 * 死锁
 */
@Slf4j
public class DeadLockDemo2 {


    //1         2           3           4           5
    //   aa           bb        cc            dd        ee
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");
        new Philosopher("aa", c1, c2).start();
        new Philosopher("bb", c2, c3).start();
        new Philosopher("cc", c3, c4).start();
        new Philosopher("dd", c4, c5).start();
        new Philosopher("ee", c5, c1).start();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Chopstick {

    private String name;


}


@Slf4j
@NoArgsConstructor
class Philosopher extends Thread {

    Chopstick left;
    Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (left) {
                synchronized (right) {
                    eat();
                }
            }
        }
    }


    private void eat() {
        log.info("eating...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


