package cn.dhx.demo.boot.udp.server;

/**
 * @Author daihongxin
 * @create 2023/4/3 11:07
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/4/3 11:07
 */

@Slf4j
public final class UdpServer {


    private static final int PORT = Integer.parseInt(System.getProperty("port", "7686"));

    public static void main(String[] args) {
        try {
            new Thread(() -> {
                try {
                    bind();
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
                    .option(ChannelOption.SO_RCVBUF, 1024 * 1024 * 10)
                    // 设置写缓冲区为1M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)
                    //解决最大接收2048个字节
                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(65535))
                    .handler(new UdpServerHandler());

            Channel channel = b.bind(PORT).sync().channel();

            System.out.println(channel);
//            System.out.println(channel2);
            channel.closeFuture().sync();

            Channel channel2 = b.bind(PORT + 1).sync().channel();
            channel2.closeFuture().sync();
            System.out.println(channel2);
        } finally {
            group.shutdownGracefully();
        }
    }
}