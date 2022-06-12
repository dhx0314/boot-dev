package cn.dhx.io.inputstreamandoutstream;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyBufferedOutputStream {

    @Test
    public void fun1() throws Exception {
        String path = "e:\\a\\Stu.java";
        String path2 = "e:\\a\\Stu3.txt";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path2));
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, readLen);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}
