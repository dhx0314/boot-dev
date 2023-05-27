package cn.dhx.nio.buffer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author daihongxin
 * @create 2023/5/25 21:43
 *
 */
@Slf4j
public class MappedByteBufferDemo {

    @Test
    public void fun2() throws Exception {
        RandomAccessFile rw = new RandomAccessFile("nio/data2.txt", "rw");
        FileChannel channel = rw.getChannel();

        /**
         * 参数 1:FileChannel.MapMode.READ_WRITE 使用的读写模式
         * 参数 2：    0：可以直接修改的起始位置
         * 参数 3:    5: 是映射到内存的大小（不是索引位置），即将 nio/data2.txt 的多少个字节映射到内存
         * 可以直接修改的范围就是 0-5
         * 实际类型 DirectByteBuffer
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0, (byte) 'h');
        mappedByteBuffer.put(2, (byte) '9');
        rw.close();

    }
}
