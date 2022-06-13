package cn.dhx.io.inputstreamandoutstream;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

public class MyPrintStream {

    @Test
    public void fun1() throws Exception {
        PrintStream out = System.out;
        out.println("hello");//写入到标准输出 即显示器

        out.write("hi".getBytes());
        out.close();

        // 重定向输出设备 输出到文件
        System.setOut(new PrintStream("e:\\a\\printStream.txt"));
        System.out.println("hello , 世界");

    }
}
