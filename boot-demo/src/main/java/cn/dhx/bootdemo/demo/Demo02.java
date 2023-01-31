package cn.dhx.bootdemo.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Demo02 {
    public static void main(String[] args) {


        HashMap<String, String> stringStringHashMap = new HashMap<>();

//        stringStringHashMap.put("1","a");
//        stringStringHashMap.put("2","b");
//        stringStringHashMap.put("3","c");

        Collection<String> values = stringStringHashMap.values();


        ArrayList<String> strings = new ArrayList<>(values);




    }


}
