package cn.dhx.bootdemo.ftp.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;



public class Byte2InputStream {

    /**
     * 功能描述: byte数组转 InputStream
     *
     * @param bytes byte数组
     * @return java.io.InputStream
     * @author xiaobu
     * @date 2019/3/28 16:01
     * @version 1.0
     */
    public static InputStream byte2InputStream(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }


    /**
     * 功能描述:
     *
     * @param inputStream 输入流
     * @return byte[] 数组
     * @author xiaobu
     * @date 2019/3/28 16:03
     * @version 1.0
     */
    public static byte[] inputStream2byte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inputStream.read(buff, 0, 100)) > 0) {
            byteArrayOutputStream.write(buff, 0, rc);
        }
        return byteArrayOutputStream.toByteArray();
    }



    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
    public static void main(String[] args) {
        String str = "你好呀";
        byte[] bytes = str.getBytes();
        InputStream inputStream = byte2InputStream(bytes);
        try {
            byte[] bytes1 = inputStream2byte(inputStream);
            String string = new String(bytes1, StandardCharsets.UTF_8);
            System.out.println("string = " + string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}