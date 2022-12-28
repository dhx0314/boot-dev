package cn.dhx.bootdemo.demo;

public interface IHello {

    default void fun1() {
        System.out.println("-------------------------");
    }

    public static void fun2() {
        System.out.println("-------------------------");
    }

    public abstract void fun3();

    void fun4();

}
