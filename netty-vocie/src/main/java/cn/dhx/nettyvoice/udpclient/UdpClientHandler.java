package cn.dhx.nettyvoice.udpclient;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;


import java.nio.charset.StandardCharsets;

public class UdpClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private int i;

    //接受服务端发送的内容
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) {
        System.out.println("客户端接收到消息：" + packet.content().toString(StandardCharsets.UTF_8));
        // 向客户端发送消息
        i++;
        if (i < 5) {
            ByteBuf byteBuf = Unpooled.copiedBuffer("你好服务器".getBytes(StandardCharsets.UTF_8));
            ctx.writeAndFlush(new DatagramPacket(byteBuf, packet.sender()));
        }


    }

}
