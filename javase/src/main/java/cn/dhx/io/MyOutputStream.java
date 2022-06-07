package cn.dhx.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyOutputStream {

    @Test
    public void fun1() throws Exception {
        //output.txt 文件不存在的话 会自动创建,目录需要手动创建
        String filePath = "D:\\a2\\a\\output.txt";
        //当写入内容时会覆盖原来的内容
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        fileOutputStream.write("info".getBytes());
        fileOutputStream.close();
    }


    @Test
    public void fun2() throws Exception {
        //output.txt 文件不存在的话 会自动创建,目录需要手动创建
        String filePath = "D:\\a2\\a\\output.txt";
        //当写入内容时会追加在原来的内容的后面
        //    public FileOutputStream(String name, boolean append)
        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
        fileOutputStream.write('a');
        fileOutputStream.write("info2222".getBytes());
        String s = "hello,world";
        byte[] bytes = s.getBytes();
        fileOutputStream.write(bytes,0, bytes.length);
        fileOutputStream.close();
    }
}
