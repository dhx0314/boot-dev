package cn.dhx.jvm.memory.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/6/4 23:53
 */
@Slf4j
public class StackDemo {


    private static int count;

    public static void main(String[] args) {
        try {
            method();
        } catch (Throwable e) {
            log.error("count {}", count, e);
        }
    }


    // -Xss256k

    /**
     * 栈内存溢出
     * java.lang.StackOverflowError: null
     */
    @Test
    public void fun1() {
        try {
            method();
        } catch (Throwable e) {
            log.error("count {}", count, e);
        }
    }

    public static void method() {
        count++;
        method();
    }
}
