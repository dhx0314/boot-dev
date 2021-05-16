package cn.dhx.boot.demo;

public class Test1 {

    public static void main(String[] args) {
        boolean a=true;
        boolean b=true;
        boolean c=false;
        boolean d=false;



        System.out.println(a^b);
        System.out.println(a^c);
        System.out.println(c^a);
        System.out.println(c^d);
        // false
        // true
        // true
        // false


//        Java 先执行 &&， 在执行 || 。不是按照从左到右执行。

        System.out.println("----------------");
        System.out.println(false && true || true);
        System.out.println(false && false || true);
        System.out.println(false && true || false);
        System.out.println(true || true && false);
        System.out.println(true && true || false && true);
        System.out.println(true && false || false && true);
        System.out.println(false && true || true && false);




    }
}
