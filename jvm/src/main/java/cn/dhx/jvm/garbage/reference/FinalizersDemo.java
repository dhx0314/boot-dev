package cn.dhx.jvm.garbage.reference;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Author daihongxin
 * @create 2023/6/8 10:45
 *
 * 测试终结器
 */
@Slf4j
public class FinalizersDemo {



    // -Xmx20m -XX:+PrintGCDetails -verbose:gc

    public static void main(String[] args) throws IOException {

        My my = new My();
        System.in.read();
        my = null;
        System.gc();

        System.in.read();
    }
}


class My {
    @Override
    protected void finalize() throws Throwable {
        System.out.println(Thread.currentThread() + " do finalize...");
    }
}