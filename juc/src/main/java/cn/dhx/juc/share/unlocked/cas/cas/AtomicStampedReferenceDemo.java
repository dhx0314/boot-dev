package cn.dhx.juc.share.unlocked.cas.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author daihongxin
 * @create 2023/5/24 13:41
 * <p>
 * AtomicStampedReference 拥有版本号
 */
@Slf4j
public class AtomicStampedReferenceDemo {

    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) {
        log.info("start");
        String prev = ref.getReference();
        int stamp = ref.getStamp();
        log.info("stamp {}", stamp);
        other();
        boolean cFlag = ref.compareAndSet(prev, "c", stamp, stamp + 1);
        log.info("A -> C {}", cFlag);

    }


    private static void other() {
        new Thread(() -> {
            log.info("A -> B  {}", ref.compareAndSet(ref.getReference(), "B", ref.getStamp(), ref.getStamp() + 1));
            log.info("stamp {}", ref.getStamp());
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            log.info("B -> A  {}", ref.compareAndSet(ref.getReference(), "A", ref.getStamp(), ref.getStamp() + 1));
            log.info("stamp {}", ref.getStamp());
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
