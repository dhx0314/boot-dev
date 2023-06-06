package cn.dhx.jvm.memory.heap;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author daihongxin
 * @create 2023/6/5 20:36
 */
@Slf4j
public class HeapDemo {



    // -Xmx8m

    /**
     * 堆内存溢出
     */
    @Test
    public void fun1() {
        int i = 0;
        try {
            ArrayList<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
