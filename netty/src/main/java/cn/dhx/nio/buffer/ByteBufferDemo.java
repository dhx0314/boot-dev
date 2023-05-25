package cn.dhx.nio.buffer;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author daihongxin
 * @create 2023/5/25 13:44
 */
@Slf4j
public class ByteBufferDemo {

    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("netty/nio/data.txt").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {
                int len = channel.read(buffer);
                log.info("read length {}", len);
                if (len == -1) {
                    break;
                }
                //  切换 buffer 读模式
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    log.info("msg {}", (char) b);
                }
                // 切换 buffer 写模式
                buffer.compact();
            }
        } catch (Exception e) {
            log.error("error", e);
        }
    }
}
