package cn.dhx.bootdemo.demo;

import cn.dhx.bootdemo.pojo.RTVoiceRequest;

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
