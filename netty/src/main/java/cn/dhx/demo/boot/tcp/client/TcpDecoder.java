package cn.dhx.demo.boot.tcp.client;

import cn.dhx.util.NetByteUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TcpDecoder extends ByteToMessageDecoder {


    private ByteBuf tempMessage = Unpooled.buffer();

    private byte[] bytes4 = new byte[4];

    private static final int POCKET_SIZE = 20;

    private boolean flag = false;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {

        int inSize = byteBuf.readableBytes();
        flag = false;

        log.info("recv {} byte", inSize);
        ByteBuf inMessage;

        //加上上次未读取完成的字节
        if (tempMessage.readableBytes() == 0) {
            inMessage = byteBuf;
        } else {
            inMessage = Unpooled.buffer();
            inMessage.writeBytes(tempMessage);
            inMessage.writeBytes(byteBuf);
        }


        int counter = inMessage.readableBytes() / POCKET_SIZE;

        for (int i = 0; i < counter; i++) {
            System.out.println(i);
            int readable = inMessage.readableBytes();
            if (readable < 4) {
                break;
            }
            inMessage.readBytes(bytes4);
            int length = NetByteUtil.bytesToInt(bytes4);
            System.out.println(length);
            readable = inMessage.readableBytes();
            System.out.println(readable);
            if (readable < length) {
                flag = true;
                break;
            }
            byte[] bytes = new byte[length];
            inMessage.readBytes(bytes);
            //将处理的好的消息放入list中向下传递
            list.add(bytes);
        }

        tempMessage.clear();
        if (inMessage.readableBytes() != 0) {
            if (flag) {
                tempMessage.writeBytes(bytes4);
            }
            inMessage.readBytes(tempMessage, inMessage.readableBytes());
        }

    }
}
