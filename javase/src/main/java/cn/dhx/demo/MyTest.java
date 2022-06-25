package cn.dhx.demo;


import cn.dhx.util.NetByteUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {


    @Test
    public void fun1c0625() {
//        String s = new String("18270779730");
//        byte[] sessionID = new byte[48];
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            sessionID[i]= (byte) c;
//        }
//        for (byte b : sessionID) {
//            System.out.println(b);
//        }

        byte[] bytes = new byte[3];
        bytes[0]=(byte) '1';
        System.out.println(bytes[0]);
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }


    @Test
    public void fun1b0625() {
        byte[] bytes = NetByteUtil.intToByteLittle(188);
        int i = NetByteUtil.bytesToIntLittle(bytes);
        System.out.println(i);

        Stu stu = new Stu();
        byte[] wavDirect = stu.getWavDirect();
        System.out.println(wavDirect.length);
    }


    @Test
    public void funa0625() {
        String s="68731";
        byte[] wavDirectCustom = {1, 0, 0, 0};
        String s1 = new String(wavDirectCustom);
        System.out.println(s1);
        byte[] bytes1 = NetByteUtil.intToBytes(1);
//        String s1 = bytes1.toString();
        System.out.println(bytes1.length);
        int i = NetByteUtil.bytesToInt(bytes1);
        System.out.println(i);
        byte[] bytes = Stu.bytes;
        System.out.println(bytes.length);
//        System.out.println(s1);
//        String s1 = new String(wavDirectCustom);
//        System.out.println(s1);
//        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
//        System.out.println(bytes.length);
    }


    @Test
    public void fun1awe() {
//        byte[] bytes={'V','C'};
        byte[] bytes={86,67};
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        String s = new String(bytes);
        System.out.println(s);
    }





    @Test
    public void fun1awea() {
        byte[] bytes = new byte[4];
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }

        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.get();
        System.out.println(i);
    }


    @Test
    public void arra() {
//        int[] arr1=new int[4];
//        int[] arr2=new int[1];
//
//        if (arr1.length < arr2.length * 2) {
//            System.out.println("aa");
//        }
        Integer i1 = 33;
        Integer i2 = 33;
        System.out.println(i1 == i2);

    }

    @Test
    public void fun1aa() {
        System.out.println(digui(100));
    }


    @Test
    public void funa2332() {
        byte[] bytes = new byte[4];
        bytes[0]= (byte) 0x00;
        bytes[1]= (byte) 0x00;
        bytes[2]= (byte) 0x00;
        bytes[3]= (byte) 0xb9;
        int i = NetByteUtil.bytesToInt(bytes);
        System.out.println(i);

    }


    public int digui(int i) {
        if (i == 1) {
            return 1;
        }
        return i+digui(i-1);
    }


    @Test
    public void fun1a2() {
        System.out.println(digui2(1));
    }

    public int digui2(int i) {
        if (i == 100) {
            return 100;
        }
        return i+digui2(i+1);
    }

    @Test
    public void fun1() {
        String number="901827077973011111";
//        String number="18270779730";
        String regex="\\d{11,}";
        boolean matches = number.matches(regex);
        System.out.println(matches);
        String firstNum = String.valueOf(number.charAt(0));
        String secondNum = String.valueOf(number.charAt(1));
        System.out.println(firstNum);
        System.out.println(secondNum);
    }


    @Test
    public void fu1() {
//        String json="{\"method\":\"makeCall\",\"object\":\"cti\",\"params\":[{\"dest\":\"9018270779730\",\"deviceId\":\"6873\",\"origin\":\"6873\"}]}";

//        String json = "{\"method\":\"makeCall\",\"object\":\"cti\",\"params\":[{\"userData\":{\"map\":{\"uui\":\"90007238test\"}},\"dest\":\"9018270779730\",\"deviceId\":null,\"origin\":null}]}";

//        String json="{\"method\":\"makeCall\",\"object\":\"cti\",\"params\":[{\"userData\":{\"map\":{\"uui\":\"90007238test\"}},\"dest\":\"9018270779730\",\"deviceId\":\"\",\"origin\":\"\"}]}";
        String json = "{\"method\":\"makeCall\",\"object\":\"cti\",\"params\":[{\"userData\":{\"map\":{\"uui\":\"90007238test\"}},\"dest\":\"9018270779730\",\"deviceId\":\"\",\"origin\":null}]}";


        JsonParser parser = new JsonParser();
        JsonObject asJsonObject = parser.parse(json).getAsJsonObject();
        JsonElement method1 = asJsonObject.get("method");
        if (null != method1 && !method1.isJsonNull()) {
            String method = method1.getAsString();
            if ("makeCall".equals(method)) {
                JsonArray jsonArray = asJsonObject.get("params").getAsJsonArray();
                if (null != jsonArray && !jsonArray.isJsonNull()) {
                    if (jsonArray.size() > 0) {
                        JsonObject asJsonObject1 = jsonArray.get(0).getAsJsonObject();
                        JsonElement deviceId = asJsonObject1.get("deviceId");
//                        deviceId":null  -> deviceId.isJsonNull()
//                        deviceId":"" -> cti 会报错提示无效分机号
                        if (null == deviceId || deviceId.isJsonNull()) {
                            System.out.println("fail deviceId ");
                        }
                        JsonElement origin = asJsonObject1.get("origin");
                        if (null == origin || origin.isJsonNull()) {
                            System.out.println("fail origin");
                        }

                    }
                }
            }
        }
        System.out.println("----- ok");


    }


    @Test
    public void fu12() {
        String s = null;
        System.out.println("aa".equals(s));
    }
}





