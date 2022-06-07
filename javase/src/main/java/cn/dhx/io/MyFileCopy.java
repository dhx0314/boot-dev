package cn.dhx.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyFileCopy {

    @Test
    public void fun1() throws Exception {
        String filePath = "D:\\a2\\a\\copy.txt";
        String filePath2 = "D:\\a2\\a\\copy2.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath2,true);
        byte[] bytes=new byte[1024];
        int readLen=0;
        while ((readLen = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes,0,readLen);
        }
        fileOutputStream.close();
        fileInputStream.close();


    }
}
