package cn.dhx.demo;

import cn.dhx.util.NetByteUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {
    public static void main(String[] args) {
//        byte[] bytes = NetByteUtil.intToBytes(100);
//        System.out.println(Arrays.toString(bytes));
//
//        byte[] bytes2 = NetByteUtil.intToByteBig(100);
//        System.out.println(Arrays.toString(bytes2));

//        byte[] bytes = new byte[4];
//        bytes[0]= (byte) 0x90;
//        bytes[1]= (byte) 0x01;
//        bytes[2]= 0;
//        bytes[3]= 0;
//        int i1 = NetByteUtil.bytesToIntLittle(bytes);
//        System.out.println(i1);

        String s=null;
        System.out.println("aa".equals(s));
    }

    @Test
    public void fun1() {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        for (int i = 0; i < 10; i++) {
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println(andIncrement);
        }
        System.out.println(atomicInteger);
        System.out.println(atomicInteger);
        System.out.println(atomicInteger);

    }

}
