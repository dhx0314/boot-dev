package cn.dhx.java8.interfacedemo;

public interface MyInterface {

    public static String s="aa";

    public abstract void method();

    public static void methodStatic() {
        System.out.println("static method");
    }

    public default void methodDefault() {
        System.out.println("static default");
    }
}
