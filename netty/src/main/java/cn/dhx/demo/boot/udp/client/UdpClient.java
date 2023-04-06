package cn.dhx.demo.boot.udp.client;

/**
 * @Author daihongxin
 * @create 2023/4/3 11:08
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.SocketUtils;

import java.util.concurrent.TimeUnit;


public final class UdpClient {

    static final int PORT = Integer.parseInt(System.getProperty("port", "7686"));


    public static void main(String[] args) {



        try {
            new Thread(()->{
                try {
                    bind();
                    System.out.println("test");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            System.out.println("----");
            TimeUnit.MINUTES.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void bind() throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    // 设置读缓冲区为 10M
                    .option(ChannelOption.SO_RCVBUF, 1024 * 1024*10)
                    // 设置写缓冲区为1M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)
                    //解决最大接收2048个字节
                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(65535))
                    .handler(new UdpClientHandler());

            Channel ch = b.bind(0).sync().channel();

            ch.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer("4444444", CharsetUtil.UTF_8),
                    SocketUtils.socketAddress("127.0.0.1", PORT)));
            ch.closeFuture().sync();
            System.out.println("-------");
        } finally {
            group.shutdownGracefully();
        }

    }
}