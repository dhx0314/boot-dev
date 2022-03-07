package cn.dhx.boot.demo;

import cn.dhx.boot.pojo.RTVoiceRequest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo18 {

    public static void main(String[] args) {
        RTVoiceRequest rtVoiceRequest = new RTVoiceRequest();
        System.out.println(rtVoiceRequest);
//        int integer = rtVoiceRequest.getInteger();
//        System.out.println(integer);
        int anInt = rtVoiceRequest.getAnInt();
        System.out.println(anInt);
    }

}
