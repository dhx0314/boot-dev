package cn.dhx.java8.lambda;

import org.junit.Test;

public class MyLambda {

    @Test
    public void fun1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        }).start();
    }

    @Test
    public void fun2() {
        new Thread(() -> {
            System.out.println("test");
        }).start();
    }

    @Test
    public void fun3() {
        new Thread(() ->
                System.out.println("hello")
        ).start();
    }


}
