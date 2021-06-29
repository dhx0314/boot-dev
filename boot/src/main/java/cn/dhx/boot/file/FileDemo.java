package cn.dhx.boot.file;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class FileDemo {


    public static void main(String[] args) throws Exception {
        //符合Java一种设计模式:装饰者设计模式(过滤器:Filter)
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bos.txt")) ;

        //写数据

//        byte[] bytes = null;
        byte[] bytes = new byte[10];
//        bytes=null;
//        bos.write("hello".getBytes());
        bos.write(bytes,0,bytes.length);
        //释放资源
        bos.close();
    }
}
