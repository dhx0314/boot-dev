package cn.dhx.io.streamio.bytestream;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyBufferedOutputStream {

    //默认8k缓冲区

    @Test
    public void fun1() throws Exception {
        String readPath = "io\\Stu.java";
        String writePath = "io\\BufferedOutputStream.txt";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(readPath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(writePath));
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, readLen);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }

}
