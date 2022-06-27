package cn.dhx.java8.methodrefIntro;

import org.junit.Test;

import java.util.Date;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyMethodRef2 {

    @Test
    public void fun1() {
        Date date = new Date();
        Supplier<Long> supplier = () -> {
            return date.getTime();
        };

        Long aLong = supplier.get();
        System.out.println(aLong);
    }


    //对象::方法
    @Test
    public void fun2() {
        Date date = new Date();
        //被引用的方法,参数要和接口中抽象方法的参数一样
        //当接口抽象方法有返回值时，被引用的方法也必须有返回值
        Supplier<Long> supplier = date::getTime;
//        long time = date.getTime();
        Long aLong = supplier.get();
        System.out.println(aLong);
    }

    //类名::静态方法
    @Test
    public void fun3() {
        Supplier<Long> supplier = System::currentTimeMillis;
//        long l = System.currentTimeMillis();
        Long aLong = supplier.get();
        System.out.println(aLong);
    }


    //类名::实例方法
    @Test
    public void fun4() {
//        Function<String,Integer> function =(str) ->{
//            return str.length();
//        };

        //注意 类名::实例参数 实际上会将第一个参数作为方法的调用者
        Function<String, Integer> function = String::length;
        Integer l = function.apply("asdfg");
        System.out.println(l);
    }
}
