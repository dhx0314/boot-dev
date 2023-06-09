package cn.dhx.io.streamio.other;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @author dhx
 */

public class MyRandomAccessFile {

    @Test
    public void write() throws Exception {
        String path="io\\Random.txt";
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
    public void read() throws Exception {
        String path="io\\Random2.txt";
        File file = new File(path);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(4);
        System.out.println(randomAccessFile.getFilePointer());//4
        randomAccessFile.write("zz".getBytes());
        randomAccessFile.close();
        //原始内容  abcd1234
        //修改后    abcdzz34
    }

    @Test
    public void fun3() throws Exception {
        String path="io\\Random2.txt";
        // 文件内容 abcdzz34
        File file = new File(path);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(4);
        System.out.println(randomAccessFile.getFilePointer());//4
        int readLength = 0;
        byte[] bytes = new byte[1024];
        while ((readLength = randomAccessFile.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,readLength));
        }
    }
}
