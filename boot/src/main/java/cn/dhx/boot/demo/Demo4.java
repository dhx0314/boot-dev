package cn.dhx.boot.demo;

public class Demo4 {

    public static void main(String[] args) {
        try {
          fun1();
        } catch (Exception e) {
            System.out.println("main");
            System.out.println(e);
        }
    }

    public static void fun1() throws Exception {
        try {
            int i=1/0;
        }  finally {
            System.out.println("fi");
        }
    }
}
