package cn.dhx.demo.boot.udp.server;

/**
 * @Author daihongxin
 * @create 2023/4/3 11:07
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author daihongxin
 * @create 2023/4/3 11:07
 */
public final class UdpServer {

    private static final int PORT = Integer.parseInt(System.getProperty("port", "7686"));


    public static void main(String[] args) throws Exception {
            bind();

        while (true) {
            Thread.sleep(10000000);
        }
    }


    public static void bind() {
        try {
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    // 设置读缓冲区为 10M
                    .option(ChannelOption.SO_RCVBUF, 1024 * 1024 * 10)
                    // 设置写缓冲区为1M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)
                    //解决最大接收2048个字节
                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(65535))
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new UdpServerHandler());
                        }
                    });

            Channel channel = bootstrap.bind(7686).sync().channel();
            System.out.println(channel);
            Channel channel1 = bootstrap.bind(7685).sync().channel();
            System.out.println(channel1);
//            channel.closeFuture().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }
}