package cn.dhx.jvm.memory.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author daihongxin
 * @create 2023/6/5 22:55
 */
@Slf4j
public class StringTableDemo2 {


    // -Xmx10m
    // -Xmx10m -XX:-UseGCOverheadLimit
    @Test
    public void fun1() {
        List<String> list = new ArrayList<String>();
        int i = 0;
        try {
            for (int j = 0; j < 260000; j++) {
                list.add(String.valueOf(j).intern());
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }


    //-Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
    @Test
    public void fun2() {
        int i = 0;
        try {
            for (int j = 0; j < 100000; j++) { // j=100, j=10000
                String.valueOf(j).intern();
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
