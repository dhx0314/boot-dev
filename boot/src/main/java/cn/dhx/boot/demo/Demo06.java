package cn.dhx.boot.demo;

public class Demo06 {

    public static void main(String[] args) {

        System.out.println(A.a);
//        A a = new A();
//        a.a = 2;
    }
}

class A {
    public static final int a = 0;

    static  {
        System.out.println("---------------");
    }
}
