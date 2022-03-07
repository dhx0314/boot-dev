package cn.dhx.boot.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class Demo {


    public static void main(String[] args) {
        try {
            fun();
            fun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fun() throws Exception {
        String s = "a.txt";
        File file = new File(s);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("createNewFile()");
        }else {
            System.out.println("file exits");
        }
        String s1 = UUID.randomUUID().toString();
        System.out.println(s1);
        FileWriter fileWritter = new FileWriter(file.getName(), true);
        fileWritter.write("\r\n"+s1);
        fileWritter.close();
    }
}
