package cn.dhx.demo.java.simplews.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class Demo {

    public static void main(String[] args) {
        byte[] bytes = new byte[5];
        bytes[0]=0;
        bytes[1]=1;
        bytes[2]=2;
        bytes[3]=3;
        bytes[4]=4;
        ByteBuf buffer = Unpooled.buffer(bytes.length);
        buffer.writeBytes(bytes);
        byte[] bytes1 = new byte[3];
        ByteBuf byteBuf = buffer.readBytes(bytes1);
        for (byte b : bytes1) {
            System.out.println(b);
        }


        byte[] bytes2 = new byte[2];
        buffer.readBytes(bytes2);
        for (byte b : bytes2) {
            System.out.println(b);
        }
    }
}
