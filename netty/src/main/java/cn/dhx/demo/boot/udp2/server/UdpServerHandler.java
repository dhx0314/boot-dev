package cn.dhx.demo.boot.udp2.server;


import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/4/3 11:07
 */
@Slf4j
@ChannelHandler.Sharable
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {


    @Override
    public void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        String msg = packet.content().toString(CharsetUtil.UTF_8);
        log.info("服务端接收消息 {}",msg);
        if (msg.startsWith("1")) {
            ctx.write(new DatagramPacket(
                    Unpooled.copiedBuffer("QOTM:111111", CharsetUtil.UTF_8), packet.sender()));
        } else {
            ctx.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer("QOTM:2222222222", CharsetUtil.UTF_8), packet.sender()));
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        // We don't close the channel because we can keep serving requests.
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("Channel {} became active, remote address {}.", ctx.channel(), ctx.channel().remoteAddress());

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("Channel {} became inactive, remote address {}.", ctx.channel(), ctx.channel().remoteAddress());
        ctx.close();
    }

}