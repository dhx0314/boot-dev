package cn.dhx.io.old.bio.stream;

import org.junit.Test;

import java.io.FileInputStream;

public class MyInputStream {

    @Test
    public void fun1() throws Exception {
        String filePath = "D:\\a2\\a\\a1.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int readDate = 0;
        while ((readDate = fileInputStream.read()) != -1) {
            System.out.println((char) readDate);
        }
        fileInputStream.close();
    }

    @Test
    public void fun2() throws Exception {
        //hello,world
        String filePath = "D:\\a2\\a\\a1.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int readLength = 0;
        byte[] buf = new byte[8];
        while ((readLength = fileInputStream.read(buf)) != -1) {
//            System.out.println(new String(buf));  输出有问题的
            System.out.println(readLength);
            System.out.println(new String(buf, 0, readLength));
        }
        fileInputStream.close();
        //8
        //hello,wo
        //3
        //rld
    }
}
