package cn.dhx.bootdemo.demo;

import java.util.concurrent.ConcurrentHashMap;

public class Demo04 {

    public static void main(String[] args) {
        String filePath="2023/03/24/36541931-25d5-4da0-b12b-ffa455227b1f_1.wav";

        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        String endPath = filePath.substring(0, filePath.lastIndexOf("/"));
        System.out.println(fileName);
        System.out.println(endPath);
    }
}
