package cn.dhx.function_java8.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.*;

/**
 * @Author daihongxin
 * @create 2023/5/20 1:04
 */
@Slf4j
public class LambdaDemo {

    @Test
    public void fun0() {
        new Thread(()-> System.out.println("aa")).start();
    }

    @Test
    public void fun1() {
        int i = calculateNum((a, b) -> a + b);
        System.out.println(i);
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a =10;
        int b = 20;
        return operator.applyAsInt(a,b); 
    }

    @Test
    public void fun2() {
        printNum((x) -> x % 2 == 0);
    }

    public static void printNum(IntPredicate predicate) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void fun2_2() {
        printNum2(x ->  x % 2 == 0);
    }

    public static void printNum2(Predicate<Integer>  predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void fun3() {
        Integer integer = typeCover(Integer::valueOf);
        System.out.println(integer);

        String s1 = typeCover(s -> s + s);
        System.out.println(s1);
    }


    public static <R> R typeCover(Function<String,R> function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }


    @Test
    public void fun4() {
        foreachArr(System.out::println);
    }

    public static void foreachArr(Consumer<Integer> consumer){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }
























}
