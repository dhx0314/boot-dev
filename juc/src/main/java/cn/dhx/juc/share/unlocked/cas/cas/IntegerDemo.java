package cn.dhx.juc.share.unlocked.cas.cas;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author daihongxin
 * @create 2023/5/18 20:36
 */
@Slf4j
public class IntegerDemo {

    @Test
    public void fun1() {
        AtomicReference<BigDecimal> bigDecimalAtomicReference = new AtomicReference<>(new BigDecimal("10000"));
        SafeBigDecimalAccount safeBigDecimalAccount = new SafeBigDecimalAccount(bigDecimalAtomicReference);
        BigDecimalAccount.demo(safeBigDecimalAccount);

    }
}


@NoArgsConstructor
class SafeBigDecimalAccount implements BigDecimalAccount {

    AtomicReference<BigDecimal> ref;

    public SafeBigDecimalAccount(AtomicReference<BigDecimal> ref) {
        this.ref = ref;
    }

    @Override
    public BigDecimal getBalance() {
        return ref.get();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        while (true) {
            BigDecimal prev = ref.get();
            BigDecimal next = prev.subtract(amount);
            if (ref.compareAndSet(prev, next)) {
                break;
            }
        }
    }
}

interface BigDecimalAccount {

    BigDecimal getBalance();

    void withdraw(BigDecimal amount);

    static void demo(BigDecimalAccount account) {
        ArrayList<Thread> threads = new ArrayList<>();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(() -> {
                //BigDecimal.TEN 初始化一个为10的BigDecimal对象
                account.withdraw(BigDecimal.TEN);
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
        System.out.println("account  " + account.getBalance() + "  cost " + cost);
    }
}