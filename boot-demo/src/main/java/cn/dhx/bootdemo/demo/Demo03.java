package cn.dhx.bootdemo.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Demo03 {
    public static void main(String[] args) {

//        try {
//           fun1();
//            int i=1/0;
//        } catch (Exception e) {
//            System.out.println("main");
//        }


        Map<String, String> sipCalls = new HashMap<>(1024);
        String s = sipCalls.get(null);
        System.out.println(s);


    }

    public static String  fun1() {

        try {
            int i=1/0;
        } catch (Exception e) {
            log.info("",e);
            System.out.println("-----");
        }
        return "ok";
    }
}
