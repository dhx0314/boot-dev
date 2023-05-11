package cn.dhx.juc.share.monitor.exercise;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/11 16:58
 */
@Slf4j
public class Sell {

    @Test
    public void sell() {
        for (int i = 0; i < 10; i++) {
            sellTest();
        }
    }

    @Test
    public void sellTest() {


        // 随机 1~5

        TicketWindow ticketWindow = new TicketWindow(1000);
        CopyOnWriteArrayList<Integer> addList = new CopyOnWriteArrayList<>();

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    int sell = ticketWindow.unSafeSell(randomAmount());
//                    int sell = ticketWindow.sell(randomAmount());
                    addList.add(sell);
                }
            });
            thread.start();
            threads.add(thread);
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int sum = addList.stream().mapToInt(i -> i).sum();
        System.out.println("count " + sum);

    }

    public static int randomAmount() {
        Random random = new Random();
        return random.nextInt(5) + 1;//1-5
    }
}

@Slf4j
class TicketWindow {

    private int count;

    public TicketWindow() {
    }

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int unSafeSell(int amount) {
        if (this.count >= amount) {
            this.count = this.count - amount;
        } else {
            return 0;
        }
        return amount;
    }

    public synchronized int sell(int amount) {
        if (this.count >= amount) {
            this.count = this.count - amount;
        } else {
            return 0;
        }
        return amount;
    }
}
