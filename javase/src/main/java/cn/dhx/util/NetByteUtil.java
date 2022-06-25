package cn.dhx.util;

import org.junit.Test;

public class NetByteUtil {

    public static byte[] intToBytes(int n) {
        byte[] b = new byte[4];
        b[3] = (byte) (n & 0xff);
        b[2] = (byte) (n >> 8 & 0xff);
        b[1] = (byte) (n >> 16 & 0xff);
        b[0] = (byte) (n >> 24 & 0xff);
        return b;
    }



    public static int bytesToInt(byte b[]) {
        return    b[3] & 0xff
                | (b[2] & 0xff) << 8
                | (b[1] & 0xff) << 16
                | (b[0] & 0xff) << 24;
    }

    @Test
    public void funa2332() {
        byte[] bytes = new byte[4];
        bytes[0]= (byte) 0x00;
        bytes[1]= (byte) 0x00;
        bytes[2]= (byte) 0x00;
        bytes[3]= (byte) 0xa3;
        int i = NetByteUtil.bytesToInt(bytes);
        System.out.println(i);

    }

    @Test
    public void fun1() {
        int i=10;
        byte[] bytes2 = intToBytes(320);
        for (byte aByte : bytes2) {
            System.out.println(aByte);
        }

        byte[] bytes = new byte[4];
        bytes[0]= (byte) 0;
        bytes[1]= (byte) 0;
        bytes[2]= (byte) 1;
        bytes[3]= (byte) 64;
        int i1 = bytesToInt(bytes);
        System.out.println(i1);

        String s = Integer.toHexString(11);
        System.out.println(s);
        int b = Integer.parseInt("b", 16);
        System.out.println(b);
    }
}
