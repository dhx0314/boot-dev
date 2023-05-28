package cn.dhx.juc.share.unlocked.cas.unsafe;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author daihongxin
 * @create 2023/5/28 13:52
 */
@Slf4j
public class UnsafeAccessor {
    static Unsafe unsafe;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {

        }
    }

    static Unsafe getUnsafe() {
        return unsafe;
    }
}
