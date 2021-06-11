package cn.dhx.boot.demo;

import cn.dhx.boot.config.Person;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo5 {

    public static void main(String[] args) {
//        AtomicInteger count = new AtomicInteger();
//        int i = count.get();
//        System.out.println(i);
//        Person person = new Person();
//        System.out.println(person);
        String input = "I Love Java!";

        // I Love Java!
        String result1 = String.format("info '%s' ", input);

        System.out.println(result1);
    }
}
