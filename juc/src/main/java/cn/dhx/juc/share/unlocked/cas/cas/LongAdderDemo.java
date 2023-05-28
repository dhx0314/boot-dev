package cn.dhx.juc.share.unlocked.cas.cas;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author daihongxin
 * @create 2023/5/28 13:06
 */
@Slf4j
public class LongAdderDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            demo(LongAdder::new, LongAdder::increment);
        }

        for (int i = 0; i < 5; i++) {
            demo(AtomicLong::new, AtomicLong::getAndIncrement);
        }
    }


    @Test
    public void fun1() {
        LongAdder longAdder = new LongAdder();
    }
    public static <T> void demo(Supplier<T> adderSupplier, Consumer<T> action) {

        T adder = adderSupplier.get();
        long start = System.nanoTime();
        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ts.add(new Thread(()->{
                for (int j = 0; j < 500000; j++) {
                    action.accept(adder);
                }
            }));
        }

        ts.forEach(Thread::start);
        ts.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        });

        long end = System.nanoTime();
        log.info("{} adder cost {}", adder, end - start);
    }

}



