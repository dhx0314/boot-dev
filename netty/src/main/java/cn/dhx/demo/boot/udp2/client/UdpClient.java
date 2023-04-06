package cn.dhx.demo.boot.udp2.client;

/**
 * @Author daihongxin
 * @create 2023/4/3 11:08
 */

import cn.hutool.core.lang.UUID;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
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
                    // 设置读缓冲区为 10M
                    .option(ChannelOption.SO_RCVBUF, 1024 * 1024 * 10)
                    // 设置写缓冲区为1M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)
                    //解决最大接收2048个字节
                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(65535))
                    .handler(new UdpClientHandler());

            Channel ch = b.bind(0).sync().channel();

            for (int i = 0; i < 10; i++) {
                ch.writeAndFlush(new DatagramPacket(
                        Unpooled.copiedBuffer(UUID.fastUUID().toString(), CharsetUtil.UTF_8),
                        SocketUtils.socketAddress("172.16.6.89", PORT)));

                TimeUnit.MILLISECONDS.sleep(500);
            }

//            ch.closeFuture().sync();
            System.out.println("-------");
        } catch (Exception e) {

        }


    }
}