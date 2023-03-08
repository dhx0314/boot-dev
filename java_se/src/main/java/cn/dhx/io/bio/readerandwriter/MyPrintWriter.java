package cn.dhx.io.bio.readerandwriter;

import org.junit.Test;

import java.io.FileWriter;
import java.io.PrintWriter;

public class MyPrintWriter {

    @Test
    public void fun1() {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.write("hello");
        printWriter.close();
    }

    @Test
    public void fun2() throws Exception {
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\a\\PrintWriter.txt"));
        printWriter.write("hello PrintWriter");
        printWriter.close();
    }
}
