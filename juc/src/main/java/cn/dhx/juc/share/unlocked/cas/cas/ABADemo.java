package cn.dhx.juc.share.unlocked.cas.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author daihongxin
 * @create 2023/5/18 21:48
 */
@Slf4j
public class ABADemo {

    static AtomicReference<String> ref = new AtomicReference<>("A");

    public static void main(String[] args) throws InterruptedException {
        log.info("start");
        String prev = ref.get();
        other();
        TimeUnit.SECONDS.sleep(1);
        log.info("change A -> C {}", ref.compareAndSet(prev, "C"));
    }

    public static void other() {
        new Thread(() -> {
            log.info("change A -> B {}", ref.compareAndSet(ref.get(), "B"));
        }).start();

        new Thread(() -> {
            log.info("change B -> A {}", ref.compareAndSet(ref.get(), "A"));
        }).start();
    }
}
