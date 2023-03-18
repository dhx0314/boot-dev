package cn.dhx.io.old.bio.inputstreamandoutstream;

import org.junit.Test;

public class MySystemOut {

    @Test
    public void fun1() {
        // public final static PrintStream out = null;
        // class java.io.PrintStream
        // System.out  运行类型和编译类型都是PrintStream
        System.out.println(System.out.getClass());
    }
}
