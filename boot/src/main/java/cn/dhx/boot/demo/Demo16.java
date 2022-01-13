package cn.dhx.boot.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Demo16 {

    public static void main(String[] args) throws JsonProcessingException, UnsupportedEncodingException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1","value12");
        hashMap.put("key2","value2");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(hashMap);
        System.out.println(s);
//        byte[] bytes1 = s.getBytes();
//        System.out.println(s.length());

        int length = s.length();
        length=34;
        byte[] bytes = intToBytes(length);
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }

        int i = bytesToInt(bytes);
        System.out.println(i);


    }


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
}
