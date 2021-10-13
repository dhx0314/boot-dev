package cn.dhx.boot.demo;

public class Demo03 {
    public static void main(String[] args) {
        String s="478";
        String s1="428";
        String s2="438";
        String s3="538";
        String s4="4438";
        String s5="^4\\d{2}$";

        System.out.println(s.matches("^4\\d{2}$"));
        System.out.println(s.matches(s5));
        System.out.println(s.matches("478"));
//        System.out.println(s1.matches("^4\\d{2}$"));
//        System.out.println(s2.matches("^4\\d{2}$"));
//        System.out.println(s3.matches("^4\\d{2}$"));
//        System.out.println(s4.matches("^4\\d{2}$"));
//        System.out.println(s.matches("^4\\d{2}$"));
    }
}
