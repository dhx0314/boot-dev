package cn.dhx.nettyvoice.udpserver;

import cn.dhx.nettyvoice.ali.AliASR;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;


@Slf4j
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {


    private int port;

    private int count;

    private boolean b=true;

    public UdpServerHandler(int port) {
        super();
        this.port=port;
    }

//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) {
//        log.info("[{}] 服务端接收到消息：{}" ,port, packet.content().toString(StandardCharsets.UTF_8));
//        // 向客户端发送消息
//        ByteBuf byteBuf = Unpooled.copiedBuffer("已经接收到消息!".getBytes(StandardCharsets.UTF_8));
//        ctx.writeAndFlush(new DatagramPacket(byteBuf, packet.sender()));
//
//    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet)  {
        ByteBuf content = packet.content();
        byte[] bytes = new byte[content.readableBytes()];
        content.readBytes(bytes);
        count++;
        if (count % 2000 == 0) {
            log.info("[{}] length {} count {}", port, bytes.length, count);
        }
        if (port == 9002) {
            if (b) {
                log.info("[{}] length {} start {}", port, bytes.length, count);
                new AliASR().start();
                b=false;
            }
            try {
                AliASR.pkgQueue.put(bytes);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



//        log.info("[{}] 服务端接收到消息：{}" ,port, packet.content().toString(StandardCharsets.UTF_8));
//        // 向客户端发送消息
//        ByteBuf byteBuf = Unpooled.copiedBuffer("已经接收到消息!".getBytes(StandardCharsets.UTF_8));
//        ctx.writeAndFlush(new DatagramPacket(byteBuf, packet.sender()));

    }
}
