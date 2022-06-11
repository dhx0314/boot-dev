package cn.dhx.demo;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MyTest {

    @Test
    public void fun1aa() {
        System.out.println(digui(99));
    }


    public int digui(int i) {
        if (i == 1) {
            return 1;
        }
        return i+digui(i-1);
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





