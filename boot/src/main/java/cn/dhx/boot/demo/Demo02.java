package cn.dhx.boot.demo;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Demo02 {

    public static void main(String[] args) {
        String mpss="172.16.2.108:8081;172.16.2.108:8082";
        ArrayList<String> strings = new ArrayList<>();
        strings.add("172.16.2.108:8081");
        strings.add("172.16.2.118:8081");
        strings.add("172.16.2.128:8081");
        strings.add("172.16.2.108:8082");
        strings.add("172.16.2.138:8081");
        String[] split = mpss.split(";");
        List<String> stringList = Arrays.asList(split);
        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> rangeList = new ArrayList<>();
        for (String string : strings) {
            if (stringList != null && stringList.size() > 0) {
                if (!stringList.contains(string)) {
                    rangeList.add(string);
                }
            }else {
                rangeList.add(string);
            }

        }

        for (String s : rangeList) {
            System.out.println(s);
        }
    }
}
