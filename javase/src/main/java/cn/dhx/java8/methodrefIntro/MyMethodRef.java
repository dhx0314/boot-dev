package cn.dhx.java8.methodrefIntro;

import org.junit.Test;

import java.util.function.Consumer;

public class MyMethodRef {


    @Test
    public void fun1() {
        printTotal((arr) -> {
            getTotal(arr);
        });

        //让这个指定的方法去重写接口的抽象方法,到时候掉用接口的抽象方法就是调用传递过去的这个方法
        printTotal(MyMethodRef::getTotal);
    }

    public static void getTotal(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }
        System.out.println(sum);
    }

    public void printTotal(Consumer<int[]> consumer) {
        int[] arr = {1, 2, 3, 5};
        consumer.accept(arr);

    }
}
