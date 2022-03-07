package cn.dhx.boot.demo;

public class Demo12 {
    public static void main(String[] args) {
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);//F
        System.out.println(i1.equals(i2));//T
        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);//F
        System.out.println(i3.equals(i4));//T
        Integer i5 = 127;//底层 Integer.valueOf(127)
        Integer i6 = 127;//-128~127
        System.out.println(i5 == i6); //T
        System.out.println(i5.equals(i6));//T
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);//F
        System.out.println(i7.equals(i8));//T
        Integer i9 = 127;//Integer.valueOf(127)
        Integer i10 = new Integer(127);
        System.out.println(i9 == i10);//F
        Integer i11=127;
        int i12=127; //只有有基本数据类型，判断的是 //值是否相同
        System.out.println(i11==i12); //T
        Integer i13=128;
        int i14=128;
        System.out.println(i13==i14);//T
        System.out.println(i13.equals(i14));//T

        String s = "aa";
        String s2 = new String("aa");
    }
}
