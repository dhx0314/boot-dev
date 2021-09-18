package cn.dhx.boot.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo02 {
    public static void main(String[] args) {

        boolean isAgent=true;
        String owner = isAgent ? "AGENT" : "CUSTOM";
        String s = Boolean.toString(isAgent);
        System.out.println(s);
    }
}
