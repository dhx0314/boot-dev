package cn.dhx.java8.interfacedemo;

import org.junit.Test;

public class MyTest {


    @Test
    public void fun1() {
        MyImpl my = new MyImpl();
        my.methodDefault();

        MyInterface.methodStatic();
    }
}
