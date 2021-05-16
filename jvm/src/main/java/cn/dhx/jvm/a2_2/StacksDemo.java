package cn.dhx.jvm.a2_2;

public class StacksDemo {

    public static void main(String[] args) {
        method1();
    }

    public static int method1() {
        return method2(1, 2);
    }

    public static int method2(int a, int b) {
        int c = a + b;
        return c;
    }

}
