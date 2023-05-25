package cn.dhx.nio.buffer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static cn.dhx.nio.buffer.ByteBufferUtil.debugAll;

/**
 * @Author daihongxin
 * @create 2023/5/25 13:44
 */
@Slf4j
public class ByteBufferMethod {


    @Test
    public void allocate_allocateDirect() {
        //分配空间
        ByteBuffer buffer = ByteBuffer.allocate(16);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16);

        System.out.println(buffer.getClass());
        System.out.println(byteBuffer.getClass());
//      class java.nio.HeapByteBuffer    -java堆内存， 读写效率低， 受垃圾回收 GC的影响
//      class java.nio.DirectByteBuffer  -直接内存，读写效率高(少一次拷贝)，不会受 GC的影响
//                                       -使用完后 需要彻底的释放，以免内存泄露

    }

    @Test
    public void read() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        debugAll(buffer);
        buffer.flip();
        byte[] bytes = new byte[2];
        buffer.get(bytes);

        System.out.println((char) bytes[0]);
        System.out.println((char) bytes[1]);
        debugAll(buffer);

        buffer.rewind();
        debugAll(buffer);

        System.out.println();
        log.info("next");
        System.out.println();


        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());

        debugAll(buffer);

        buffer.mark();
        debugAll(buffer);

        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
        debugAll(buffer);
        buffer.reset();
        debugAll(buffer);
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());


    }


    @Test
    public void writer() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 0x61);
        debugAll(buffer);

        buffer.put(new byte[]{0x62, 0x63, 0x64});
        debugAll(buffer);

        buffer.flip();

        log.info("compact---------------------------------");
        debugAll(buffer);
        System.out.println((char) buffer.get());
        debugAll(buffer);
        buffer.compact();
        buffer.flip();
        System.out.println(buffer.limit());
        debugAll(buffer);


        buffer.compact();
        buffer.put(new byte[]{0x65, 0x66});
        debugAll(buffer);
    }


    @Test
    public void string2buffer() {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello world".getBytes(StandardCharsets.UTF_8));
        debugAll(buffer);

        ByteBuffer hello = StandardCharsets.UTF_8.encode("hello");
        debugAll(hello);


        ByteBuffer wrap = ByteBuffer.wrap("world".getBytes());
        debugAll(wrap);

        ByteBuffer charset = Charset.forName("utf-8").encode("charset");
        debugAll(charset);

        buffer.flip();
        String s = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println(s);

        CharBuffer decode = Charset.forName("utf-8").decode(charset);
        System.out.println(decode.toString());
    }


    @Test
    public void scatteringReads() {

        try (RandomAccessFile rw = new RandomAccessFile("nio/scatteringReads.txt", "rw")) {
            FileChannel channel = rw.getChannel();
            ByteBuffer a = ByteBuffer.allocate(3);
            ByteBuffer b = ByteBuffer.allocate(3);
            ByteBuffer c = ByteBuffer.allocate(5);
            channel.read(new ByteBuffer[]{a, b, c});
            a.flip();
            b.flip();
            c.flip();
            debugAll(a);
            debugAll(b);
            debugAll(c);
        } catch (Exception e) {
            log.error("error", e);
        }
    }

    @Test
    public void gatheringWrites() {
        try (RandomAccessFile rw = new RandomAccessFile("nio/scatteringReads.txt", "rw")) {
            FileChannel channel = rw.getChannel();
            ByteBuffer b1 = StandardCharsets.UTF_8.encode("hello");
            ByteBuffer b2 = StandardCharsets.UTF_8.encode("world");
            ByteBuffer b3 = StandardCharsets.UTF_8.encode("测试");

            channel.write(new ByteBuffer[]{b1, b2, b3});
        } catch (Exception e) {
            log.error("error", e);
        }
    }


    @Test
    public void fun3() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 一个汉字3个字节
        buffer.put("我".getBytes(StandardCharsets.UTF_8));
        debugAll(buffer);
    }


    @Test
    public void fun4() {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);

        source.put("w are you?\nhaha!\n".getBytes());
        split(source);
    }

    public void split(ByteBuffer source) {
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n') {
                int length = i + 1 - source.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
                target.flip();
                String s = StandardCharsets.UTF_8.decode(target).toString();
                System.out.println(s);
            }
        }

        source.compact();
    }


}
