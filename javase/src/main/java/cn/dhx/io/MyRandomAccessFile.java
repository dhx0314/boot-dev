package cn.dhx.io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class MyRandomAccessFile {

    @Test
    public void fun1() throws Exception {
        String path="e:\\a\\Random.txt";
        File file = new File(path);
        // 文件不存在的话 会自动创建
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        System.out.println(randomAccessFile.getFilePointer());//0
        randomAccessFile.write("aa".getBytes());
        System.out.println(randomAccessFile.getFilePointer());//2
        System.out.println(randomAccessFile.length());//2
        randomAccessFile.close();
    }

    @Test
    public void fun2() throws Exception {
        String path="e:\\a\\Random2.txt";
        File file = new File(path);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(4);
        System.out.println(randomAccessFile.getFilePointer());//4
        randomAccessFile.write("zz".getBytes());
        randomAccessFile.close();
        //原始内容  abcd1234
        //修改后    abcdzz34
    }
}
