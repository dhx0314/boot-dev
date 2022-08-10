package cn.dhx.demo;

import cn.dhx.util.ConverterUtil;
import cn.dhx.util.NetByteUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    private final ConcurrentLinkedQueue<byte[]> pool = new ConcurrentLinkedQueue<>();

    @Test
    public void fun2a() {

        byte[] voiceBytes = new byte[320];
        for (int i = 0; i < 100; i++) {
            voiceBytes[i]= (byte) i;
        }
        byte[] bytes = new byte[320];
        System.arraycopy(voiceBytes,0,bytes,0,voiceBytes.length);
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }



    @Test
    public void fun22() {
        for (int i = 0; i <100; i++) {
            byte[] bytes = new byte[320];
            pool.add(bytes);
//            System.out.println(pool.size());
        }

        for (int i = 0; i < 100; i++) {
            byte[] poll = pool.poll();
            if ((i % 2 == 0)) {
                pool.add(poll);
            }
            System.out.println(pool.size());
        }

        System.out.println(pool.size());

    }



    @Test
    public void fun1aa() {
//        byte[] headerOfPCMU = WaveFIle.headerOfPCMU;
//        System.out.println(Arrays.toString(headerOfPCMU));
//        String s = byteToHexString(headerOfPCMU);
//        System.out.println(s);

//        for (byte b : headerOfPCMU) {
//            short s=(short) b;
//            System.out.println(s);
//        }

        byte[] bytes = new byte[172];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i]=1;
        }
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = new byte[160];
//        System.out.println(bytes1);
        System.out.println(Arrays.toString(bytes1));


        System.arraycopy(bytes, 12, bytes1, 0, 160);
        System.out.println(Arrays.toString(bytes1));
    }

    private String byteToHexString(byte[] bytes)
    {
        StringBuilder resultHexString = new StringBuilder();
        String tempStr;
        for (byte b: bytes) {
            //这里需要对b与0xff做位与运算，
            //若b为负数，强制转换将高位位扩展，导致错误，
            //故需要高位清零
            tempStr = Integer.toHexString(b & 0xff);
            //若转换后的十六进制数字只有一位，
            //则在前补"0"
            if (tempStr.length() == 1) {
                resultHexString.append(0).append(tempStr);
            } else {
                resultHexString.append(tempStr);
            }
        }
        return resultHexString.toString();
    }

























    public static void main(String[] args) throws JsonProcessingException {
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

//        String s=null;
//        System.out.println("aa".equals(s));

        Name name = new Name();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(name);
        System.out.println(s);

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
