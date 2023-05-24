package cn.dhx.juc.share.unlocked.cas.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author daihongxin
 * @create 2023/5/18 20:36
 * 原子
 */
@Slf4j
public class AtomicIntegerDemo {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        //    i
        System.out.println(i.getAndIncrement()); // 0 ,1
        System.out.println(i.incrementAndGet()); // 2 ,2
        System.out.println(i.getAndDecrement()); // 2 ,1
        System.out.println(i.decrementAndGet()); // 0 ,0

        AtomicInteger i2 = new AtomicInteger(0);
        //    i
        System.out.println(i2.getAndAdd(5)); // 0 ,5
        System.out.println(i2.addAndGet(-5)); // 0 ,0

        System.out.println("---------");
        AtomicInteger i3 = new AtomicInteger(2);
        System.out.println(i3.getAndUpdate(operand -> operand + 2));//2,4
        System.out.println(i3.updateAndGet(operand -> operand - 2));//2,2
        System.out.println(i3.updateAndGet(operand -> operand * 4));//8,8
        System.out.println("---------");
        AtomicInteger i4 = new AtomicInteger(2);
        System.out.println(i.getAndAccumulate(10, (p, x) -> p + x));//2,10
        System.out.println(i.accumulateAndGet(-10, (p, x) -> p + x));//0,0

        // getAndUpdate 如果在 lambda 中引用了外部的局部变量，要保证该局部变量是 final 的
        // getAndAccumulate 可以通过 参数1 来引用外部的局部变量，但因为其不在 lambda 中因此不必是 final
    }
}
