package cn.dhx.boot.java.basic;

public class Demo01 {

    public static void main(String[] args) {
        byte b1 = 1;                   //   0000  0000
        byte b2 = (byte) (b1 << 2);    //   0000  0010
        byte b4 = 8;                    //  0000  1000
        byte b3 = (byte) (b4 >> 2);     //  0000  0010
    }
}
