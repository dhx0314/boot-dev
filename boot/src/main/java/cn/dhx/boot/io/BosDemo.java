package cn.dhx.boot.io;

import java.io.*;

public class BosDemo {





    public void write() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\bos.txt"));
        //写数据
        byte[] bytes = "hello".getBytes();
        bos.write(bytes);
        //释放资源
        bos.close();
        bos.flush();
    }

    public void read() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d:\\bos.txt"));
        byte[] b=new byte[1024];   //代表一次最多读取1KB的内容

        int length = 0 ; //代表实际读取的字节数
        while( (length = bis.read( b ) )!= -1 ){
            //length 代表实际读取的字节数
            System.out.println(b.length);
//            for (byte b1 : b) {
//                System.out.println(b1);
//            }
        }
    }

    public void read2() {
        File file = new File("d:\\bos.txt");
        System.out.println(file.length());
    }


}
