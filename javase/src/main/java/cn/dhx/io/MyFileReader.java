package cn.dhx.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;

public class MyFileReader {

    @Test
    public void fun1() throws Exception{
        String filePath = "D:\\a2\\a\\stream.txt";
        FileReader fileReader = new FileReader(filePath);
        int data=0;
        while ((data = fileReader.read()) != -1) {
            System.out.println((char) data);
        }
        fileReader.close();

    }


    @Test
    public void fun2() throws Exception{
        String filePath = "D:\\a2\\a\\stream.txt";
        FileReader fileReader = new FileReader(filePath);
        int readLen=0;
        char[] chars=new char[8];
        // 循环读取,返回的是实际读取的字符数
        // 返回-1,说明到文件结束
        while ((readLen = fileReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, readLen));
        }
        fileReader.close();
    }
}
