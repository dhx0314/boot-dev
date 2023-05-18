package cn.dhx.demo.boot.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import org.junit.Test;
import org.junit.experimental.theories.Theory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @Author daihongxin
 * @create 2023/4/6 17:39
 */
public class MyTest {

    @Test
    public void fun2() throws FileNotFoundException {
//        ByteBuf byteBuf2 = Unpooled.copiedBuffer("hello,world!", CharsetUtil.UTF_8);
//        byte[] bytes = new byte[4];
//        ByteBuf byteBuf = byteBuf2.readBytes(bytes);
//        System.out.println(new String(bytes));
//        byte[] bytes1 = new byte[4];
//        ByteBuf byteBuf1 = byteBuf.readBytes(bytes1);
//        System.out.println(new String(bytes1));


        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(10);
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer();
        System.out.println(buf);
        for (int j = 0; j < 100; j++) {


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                sb.append("a");
            }
            buf.writeBytes(sb.toString().getBytes());
            System.out.println(buf);

        }






    }
}
