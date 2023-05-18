package cn.dhx.juc.share.unlocked.cas.account;

import java.util.ArrayList;

/**
 * @Author daihongxin
 * @create 2023/5/18 19:23
 */


public interface Account {

    Integer getBalance();

    void withdraw(Integer amount);

    static void demo(Account account) {
        ArrayList<Thread> threads = new ArrayList<>();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();
        long cost = end - l;
        System.out.println("account  " +account.getBalance() + "  cost "+cost);
    }
}
