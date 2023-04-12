package cn.dhx.io.streamio.other;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

public class MySystemInAndOut {

    @Test
    public void SystemIn() {
        // public final static InputStream in = null;
        // class java.io.BufferedInputStream
        // System.in 编译类型 InputStream
        // System.in 运行类型 BufferedInputStream
        System.out.println(System.in.getClass());


        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
    }


    @Test
    public void SystemOut() {
        // public final static PrintStream out = null;
        // class java.io.PrintStream
        // System.out  运行类型和编译类型都是PrintStream
        PrintStream out = System.out;
        System.out.println(System.out.getClass());
    }
}
