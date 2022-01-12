package cn.dhx.boot.demo;

public class Demo15 {

    public static void main(String[] args) {
        TransferModeEnum udp = TransferModeEnum.UDP;
        String s = udp.toString();
        System.out.println(s);
        System.out.println("UDP".equals(s));
//        fun1(null);
        String name = udp.name();
        System.out.println(udp.name());
    }

    public static void fun1(String str) {
        str="aa";
        System.out.println(str);
    }
}
