package cn.dhx.boot.demo;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author daihongxin
 * @create 2023/3/8 19:28
 */
public class NIO {

    public static void main(String[] args) throws IOException {
        FileChannel open = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
        InputStream inputStream = new FileInputStream("a");
        byte[] bytes = IOUtils.toByteArray(inputStream);
    }


    @Test
    public void fun2() {


    }
}
