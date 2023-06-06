package cn.dhx.nio.filechannel;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.nio.ch.DirectBuffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Author daihongxin
 * @create 2023/5/25 20:18
 */
@Slf4j
public class FileChannelDemo2 {


    public static final int MB_10 = 1024 * 1024 * 10;

    public static void main(String[] args) {
        readWriteAllocate();
        readWriteAllocateDirect();
    }

    public static void readWriteAllocate() {
        long start = System.currentTimeMillis();
//        String oldPath = "C:\\D\\my\\test2.zip";
//        String newPath = "C:\\D\\my\\test3.zip";
        String oldPath = "/opt/test2.zip";
        String newPath = "/opt/test3.zip";
        try (FileChannel channel = new FileInputStream(oldPath).getChannel();
             FileChannel outChannel = new FileOutputStream(newPath).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(MB_10);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }
        } catch (Exception e) {
            log.error("error", e);
        }
        long end = System.currentTimeMillis();
        log.info("cost {}", end - start);
        long l = end - start;
        System.out.println("buffer" + l);
    }


    public static void readWriteAllocateDirect() {
        long start = System.currentTimeMillis();
//        String oldPath = "C:\\D\\my\\test2.zip";
//        String newPath = "C:\\D\\my\\test4.zip";

        String oldPath = "/opt/test2.zip";
        String newPath = "/opt/test4.zip";
        ByteBuffer buffer = null;
        try (FileChannel channel = new FileInputStream(oldPath).getChannel();
             FileChannel outChannel = new FileOutputStream(newPath).getChannel()) {
            buffer = ByteBuffer.allocateDirect(MB_10);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }
        } catch (Exception e) {
            log.error("error", e);
        } finally {
//            DirectBuffer directBuffer = (DirectBuffer) buffer;
//            directBuffer.cleaner().clean();
        }
        long end = System.currentTimeMillis();
        log.info("cost {}", end - start);
        long l = end - start;
        System.out.println("DirectBuffer" + l);
    }
}
