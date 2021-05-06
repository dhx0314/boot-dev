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
    }
}
