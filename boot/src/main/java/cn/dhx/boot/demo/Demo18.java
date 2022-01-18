package cn.dhx.boot.demo;

import cn.dhx.boot.pojo.RTVoiceRequest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo18 {

    public static void main(String[] args) {
        RTVoiceRequest rtVoiceRequest = new RTVoiceRequest();
        rtVoiceRequest.setCallId("aaa");
        rtVoiceRequest.setDeviceId("ddddd");
        rtVoiceRequest.put("aa","bb");
        System.out.println(rtVoiceRequest.toString());
    }

}
