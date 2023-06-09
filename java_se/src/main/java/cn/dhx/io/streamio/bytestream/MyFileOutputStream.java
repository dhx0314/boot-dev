package cn.dhx.io.streamio.bytestream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyFileOutputStream {

    @Test
    public void write() throws Exception {
        //output.txt 文件不存在的话 会自动创建,目录需要手动创建
        String filePath = "io\\FileOutputStream.txt";
        //当写入内容时会覆盖原来的内容
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        fileOutputStream.write("info".getBytes());
        fileOutputStream.close();
    }


    @Test
    public void write2() throws Exception {
        //output.txt 文件不存在的话 会自动创建,目录需要手动创建
        String filePath = "io\\FileOutputStream2.txt";
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

    @Test
    public void readAndWrite() throws Exception {
        String readFilePath = "io\\Stu.java";
        String writeFilePath = "io\\fileOutputStream3.txt";
        FileInputStream fileInputStream = new FileInputStream(readFilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(writeFilePath,true);
        byte[] bytes=new byte[1024];
        int readLen=0;
        while ((readLen = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes,0,readLen);
        }
        fileOutputStream.close();
        fileInputStream.close();


    }


    @Test
    public void fun4() throws Exception {
        //output.txt 文件不存在的话 会自动创建,目录需要手动创建
        String filePath = "D:\\a\\output.txt";
        //当写入内容时会追加在原来的内容的后面
        //    public FileOutputStream(String name, boolean append)
        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
//        fileOutputStream.write('a');
//        fileOutputStream.write("info2222".getBytes());
        String s = "hello";
        byte[] bytes = s.getBytes();
        fileOutputStream.write(bytes,2, 3);
        fileOutputStream.close();
    }
}
