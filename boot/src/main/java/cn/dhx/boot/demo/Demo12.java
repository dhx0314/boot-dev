package cn.dhx.boot.demo;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Demo12 {
    public static void main(String[] args) throws Exception {
        String filePath="D:\\a.txt";
        FileOutputStream fos = new FileOutputStream(filePath);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fos);

        byte[] bytes = new byte[100];
        bufferedOutputStream.write(bytes,0,20);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }
}
