package cn.dhx.jvm.direct;

import java.nio.ByteBuffer;
import java.util.ArrayList;


// java.lang.OutOfMemoryError: Direct buffer memory

public class DirectOutOf {

    static int _100Mb = 1024 * 1024 * 100;

    public static void main(String[] args) {
        ArrayList<ByteBuffer> byteBuffers = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100Mb);
                byteBuffers.add(byteBuffer);
                i++;
            }
        } finally {
            System.out.println(i);
        }

//        System.gc();
    }
}
