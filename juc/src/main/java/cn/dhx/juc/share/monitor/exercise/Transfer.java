package cn.dhx.juc.share.monitor.exercise;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/11 17:27
 */
@Slf4j
public class Transfer {


    @Test
    public void fun1() {
        for (int i = 0; i < 10; i++) {
            try {
                transfer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void transfer() throws InterruptedException {
        Account a = new Account(1000);
        Account b = new Account(1000);

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                a.unSafeTransfer(b, randomAmount());
//                a.transfer(b, randomAmount());
            }
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                b.unSafeTransfer(a, randomAmount());
//                b.transfer(a, randomAmount());
            }

        });
        thread2.start();

        thread.join();
        thread.join();

        log.info("Account money total {} ", b.getMoney() + a.getMoney());
    }

    public static int randomAmount() {
        Random random = new Random();
        return random.nextInt(100) + 1;//1-5
    }
}


class Account {

    private int money;

    public Account() {
    }

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void unSafeTransfer(Account target, int amount) {
        if (this.money > amount) {

            this.setMoney(this.getMoney() - amount);
            target.setMoney(target.getMoney() + amount);
        }
    }

    public void transfer(Account target, int amount) {

        synchronized (Account.class) {
            if (this.money > amount) {
                this.setMoney(this.getMoney() - amount);
                target.setMoney(target.getMoney() + amount);
            }
        }
    }
}