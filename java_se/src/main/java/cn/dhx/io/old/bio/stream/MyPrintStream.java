package cn.dhx.io.old.bio.stream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MyPrintStream {

    @Test
    public void fun1() throws Exception {
        PrintStream out = System.out;
        out.println("hello");//写入到标准输出 即显示器

        out.write("hi".getBytes());
        out.close();


    }

    @Test
    public void fun2() throws FileNotFoundException {

        // 重定向输出设备 输出到文件
        System.setOut(new PrintStream("printStream.txt"));
        System.out.println("hello , 世界");
    }
}
