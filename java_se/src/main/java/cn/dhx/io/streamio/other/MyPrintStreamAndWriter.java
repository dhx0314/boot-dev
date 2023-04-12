package cn.dhx.io.streamio.other;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;


//打印流
public class MyPrintStreamAndWriter {

    @Test
    public void PrintStream() throws Exception {
        PrintStream out = System.out;
        out.println("hello");//写入到标准输出 即显示器

        out.write("hi".getBytes());
        out.close();


    }

    @Test
    public void PrintStream2() throws FileNotFoundException {

        // 重定向输出设备 输出到文件
        System.setOut(new PrintStream("io\\printStream.txt"));
        System.out.println("hello , 世界");
    }


    //PrintWriter 与 PrintStream 相同。PrintStream 只能接字节流，而 PrintWriter 既能接字节流又能接字符流。
    @Test
    public void PrintWriter() {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.write("hello");
        printWriter.close();

        PrintStream out = System.out;

    }

    @Test
    public void PrintWriter2() throws Exception {
        PrintWriter printWriter = new PrintWriter(new FileWriter("io\\PrintWriter.txt"));
        printWriter.write("hello PrintWriter");
        printWriter.close();
    }
}
