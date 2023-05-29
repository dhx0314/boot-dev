package cn.dhx.nio.filechannel;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Author daihongxin
 * @create 2023/5/25 20:18
 */
@Slf4j
public class FileChannelDemo {


    @Test
    public void fun1() {
        String fileName = "nio/channel.txt";

        try (FileChannel toChannel = new FileOutputStream(fileName).getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
//            byteBuffer.putInt(1);
            byteBuffer.put("aa".getBytes(StandardCharsets.UTF_8));
            byteBuffer.flip();
            toChannel.write(byteBuffer);
        } catch (Exception e) {
            log.error("error");
        }
    }

    @Test
    public void transferTo() {
        String from = "nio/data.txt";
        String to = "nio/to.txt";
        try (FileChannel fromChannel = new FileInputStream(from).getChannel();
             FileChannel toChannel = new FileOutputStream(to).getChannel()) {
            fromChannel.transferTo(0, fromChannel.size(), toChannel);
        } catch (Exception e) {
            log.error("error", e);
        }
    }


    @Test
    public void transferTo2() {
        String from = "C:\\D\\a\\test2.zip";
        String to = "C:\\D\\a\\test3.zip";
        try (FileChannel fromChannel = new FileInputStream(from).getChannel();
             FileChannel toChannel = new FileOutputStream(to).getChannel()) {

            long size = fromChannel.size();
            // left 变量代表剩余多少字节
            for (long left = size; left > 0; ) {
                log.info("position: {} left {}", size - left, left);
                long transferSize = fromChannel.transferTo((size - left), left, toChannel);
                log.info("transferTo size {}", transferSize);
                left -= transferSize;
            }
        } catch (Exception e) {
            log.error("error", e);
        }
    }
}
