package cn.dhx.io.inputstreamandoutstream;

import org.junit.Test;

import java.awt.*;
import java.util.Scanner;

public class MySystemIn {

    @Test
    public void fun1() {
        // public final static InputStream in = null;
        // class java.io.BufferedInputStream
        // System.in 编译类型 InputStream
        // System.in 运行类型 BufferedInputStream
        System.out.println(System.in.getClass());


        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
    }
}
