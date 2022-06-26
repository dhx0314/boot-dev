package cn.dhx.java8.methodrefIntro;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MyMethodRef3 {

    // 类名::new
    @Test
    public void fun1() {
//        Supplier<Person> supplier= ()->{
//            return new Person();
//        };

        //无参构造
        Supplier<Person> supplier = Person::new;
        Person person = supplier.get();
        System.out.println(person);

        //有参构造器
        BiFunction<String, Integer, Person> biFunction = Person::new;
        Person jack = biFunction.apply("jack", 20);
        System.out.println(jack);
    }
}
