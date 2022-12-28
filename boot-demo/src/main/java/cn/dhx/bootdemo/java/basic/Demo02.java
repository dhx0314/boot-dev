package cn.dhx.bootdemo.java.basic;

public class Demo02 {

    public static void main(String[] args) {
//        long ipAddress = 3232235778L;
//        String binary = Long.toBinaryString(ipAddress);
//        System.out.println(binary);
//        System.out.println((ipAddress>>24) & 0xFF);
//        System.out.println((ipAddress>>16) & 0xFF);
//        System.out.println((ipAddress>>8) & 0xFF);
//        System.out.println((ipAddress) & 0xFF);

        byte[] bytes = new byte[10];
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }
}
