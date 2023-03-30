package cn.dhx.demo.java.simplews.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class Demo2 {

    public static void main(String[] args) {
        byte[] bytes = new byte[5];
        bytes[0]=0;
        bytes[1]=1;
        bytes[2]=2;
        bytes[3]=31;
        bytes[4]=41;
        ByteBuf buffer = Unpooled.buffer(bytes.length);
        buffer.writeBytes(bytes);
        byte[] bytes1 = new byte[2];
        ByteBuf byteBuf = buffer.readBytes(bytes1);
//        for (byte b : bytes1) {
//            System.out.println(b);
//        }
        ByteBuf tempMessage = Unpooled.buffer();
        tempMessage.writeBytes(bytes1);
        buffer.readBytes(tempMessage,buffer.readableBytes());

        byte[] bytes2 = new byte[tempMessage.readableBytes()];
        tempMessage.readBytes(bytes2);
        for (byte b : bytes2) {
            System.out.println(b);
        }

        String s="{“cmd”:”CloseAudioStream”,”callid”:”1”}";
        System.out.println(s.length());
    }
}
