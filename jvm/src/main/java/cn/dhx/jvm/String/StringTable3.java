package cn.dhx.jvm.String;

public class StringTable3 {
    public static void main(String[] args) {

        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";
        String s4 = s1 + s2;
        String s5 = "ab";
        String s6 = s4.intern();

        System.out.println(s3 == s4); //false
        System.out.println(s3 == s5); //true
        System.out.println(s3 == s6);//true

        String x2 = new String("c") + new String("d");
        String x1 = "cd";
        x2.intern();

        System.out.println(x1 == x2);//false


        String xx2 = new String("c") + new String("f");
        xx2.intern();
        String xx1 = "cf";

        System.out.println(xx1 == xx2);//true
    }
}
