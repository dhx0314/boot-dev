package cn.dhx.io.streamio.other;

import org.junit.Test;

import java.io.PrintStream;

public class MySystemOut {

    @Test
    public void fun1() {
        // public final static PrintStream out = null;
        // class java.io.PrintStream
        // System.out  运行类型和编译类型都是PrintStream
        PrintStream out = System.out;
        System.out.println(System.out.getClass());
    }
}
