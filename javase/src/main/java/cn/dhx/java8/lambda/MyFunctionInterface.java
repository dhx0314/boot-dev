package cn.dhx.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MyFunctionInterface {


    //获取最大值
    @Test
    public void Supplier() {
        printMax(() -> {
            int[] arr = {100, 200, 22, 33, 44};
            Arrays.sort(arr);
            return arr[arr.length - 1];
        });
    }

    public void printMax(Supplier<Integer> supplier) {
        Integer integer = supplier.get();
        System.out.println("max=" + integer);
    }

    //字符串转小写
    @Test
    public void consumer() {
        printHello((s) -> {
            System.out.println(s.toLowerCase(Locale.ROOT));
        });

    }

    public void printHello(Consumer<String> consumer) {
        consumer.accept("HELLO");
    }


    //字符串转数字
    @Test
    public void function() {
        getNumber((s) -> {
            System.out.println("----- ");
            return Integer.valueOf(s);
        });
    }

    public void getNumber(Function<String, Integer> function) {
        Integer apply = function.apply("10");
        System.out.println(apply);
    }


    //测试字符串长度是否大于3
    @Test
    public void Predicate() {
        checkName((s -> {
            if (s.length() >= 3) {
                return true;
            } else {
                return false;
            }
        }));
    }

    public void checkName(Predicate<String> predicate) {
        boolean abc = predicate.test("abc");
        System.out.println(abc);
    }


}
