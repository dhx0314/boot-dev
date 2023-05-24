package cn.dhx.juc.share.unlocked.cas.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @Author daihongxin
 * @create 2023/5/24 13:48
 * 还是会存在ABA问题
 */
@Slf4j
public class AtomicMarkableReferenceDemo {

    private static AtomicMarkableReference ref = new AtomicMarkableReference("A", false);

    public static void main(String[] args) {
        log.info("start");
        Object prev = ref.getReference();
        boolean marked = ref.isMarked();
        log.info("marked {}",ref.isMarked());
        other();
        boolean flag = ref.compareAndSet(prev, "C", marked, !marked);
        log.info("A -> C {} ",flag);
    }



    private static void other() {
        new Thread(() -> {
            ref.compareAndSet(ref.getReference(), "B", ref.isMarked(), !ref.isMarked());
            log.info("A -> B  {}", ref.compareAndSet(ref.getReference(), "B", ref.isMarked(), !ref.isMarked()));
            log.info("marked {}",ref.isMarked());
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            log.info("B -> A  {}",ref.compareAndSet(ref.getReference(), "A", ref.isMarked(), !ref.isMarked()));
            log.info("marked {}",ref.isMarked());
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
