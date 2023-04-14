package cn.dhx.util;

import cn.hutool.core.io.IoUtil;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


public class Byte2StreamUtil {



    public static InputStream byte2InputStream(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[10 * 1024];
        int n = 0;
        while ((n = inputStream.read(buffer)) != -1) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }


    public static byte[] toByteArray2(InputStream inputStream) throws IOException {
        byte[] bytes = IOUtils.toByteArray(inputStream);
        return bytes;
    }


    public static byte[] toByteArray3(InputStream inputStream) throws IOException {
        byte[] bytes = IoUtil.readBytes(inputStream);
        return bytes;
    }

    public static void main(String[] args) {
        String str = "你好呀";
        byte[] bytes = str.getBytes();
        InputStream inputStream = byte2InputStream(bytes);
        try {
            byte[] bytes1 = toByteArray(inputStream);
            String string = new String(bytes1, StandardCharsets.UTF_8);
            System.out.println("string = " + string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}