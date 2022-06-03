package cn.dhx.map;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeMap;

public class MyTreeMap {

    @Test
    public void fun1() {
        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((String)o1).compareTo((String)o2);
            }
        });

        String s="1";

        treeMap.put("bb","22");
        treeMap.put("cc","33");
        treeMap.put("dd","33");
        treeMap.put("aa","11");
        treeMap.put("","11");
        treeMap.put("aa","222");
        System.out.println(treeMap);
    }

}
