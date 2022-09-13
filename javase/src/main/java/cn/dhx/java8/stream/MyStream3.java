package cn.dhx.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStream3 {


    @Test
    public void fun1() {
        Stream<Integer> stream = Stream.of(3, 5, 1, 22, 9, 12);
        stream.filter((s) -> {
            System.out.println(Thread.currentThread() + ":" + s);
            return s > 3;
        }).count();
    }


    //获取并行stream流
    @Test
    public void fun2() {
        ArrayList<String> arrayList = new ArrayList<>();
        Stream<String> stringStream = arrayList.parallelStream();

        Stream<String> parallel = arrayList.stream().parallel();
    }


    @Test
    public void fun3() {
        Stream<Integer> stream = Stream.of(3, 5, 1, 22, 9, 12);
        Stream<Integer> parallel = stream.parallel();
        parallel.filter((s) -> {
            System.out.println(Thread.currentThread() + ":" + s);
            return s > 3;
        }).count();

    }


    @Test
    public void fun4() {
        ArrayList<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1,1000).parallel().forEach(list::add);
        System.out.println(list.size());
    }

    @Test
    public void fun5() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        IntStream.rangeClosed(1,1000).parallel().forEach(list::add);
        System.out.println(list.size());
    }



}
