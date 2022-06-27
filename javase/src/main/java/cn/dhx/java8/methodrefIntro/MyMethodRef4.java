package cn.dhx.java8.methodrefIntro;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

public class MyMethodRef4 {

    // 类型[]::new
    @Test
    public void fun1() {

//        Function<Integer, int[]> function = (length) -> {
//            return new int[length];
//        };

        Function<Integer, int[]> function = int[]::new;
        int[] apply = function.apply(4);
        System.out.println(Arrays.toString(apply));
    }
}
