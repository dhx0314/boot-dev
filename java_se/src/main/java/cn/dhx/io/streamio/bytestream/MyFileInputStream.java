package cn.dhx.io.streamio.bytestream;

import org.junit.Test;

import java.io.FileInputStream;

public class MyFileInputStream {

    @Test
    public void read() throws Exception {
        String filePath = "io\\fileInputStream.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int readDate = 0;
        while ((readDate = fileInputStream.read()) != -1) {
            System.out.println((char) readDate);
        }
        fileInputStream.close();
    }

    @Test
    public void read2() throws Exception {
        //hello,world
        String filePath = "io\\fileInputStream.txt";
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
