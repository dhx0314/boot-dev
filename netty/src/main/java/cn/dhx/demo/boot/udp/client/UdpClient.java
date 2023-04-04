package cn.dhx.demo.boot.udp.client;

/**
 * @Author daihongxin
 * @create 2023/4/3 11:08
 */

import cn.dhx.demo.boot.udp.server.UdpServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.SocketUtils;


public final class UdpClient {

    static final int PORT = Integer.parseInt(System.getProperty("port", "7685"));

    public static void main(String[] args) throws Exception {

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
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
                            pipeline.addLast(new UdpClientHandler());
                        }
                    });

            Channel ch = bootstrap.bind(0).sync().channel();



            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < 1000; j++) {
                for (int i = 0; i < 9; i++) {
                    stringBuilder.append(i);
                }
            }

            ch.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer(stringBuilder.toString(), CharsetUtil.UTF_8),
                    SocketUtils.socketAddress("127.0.0.1", PORT)));
            ch.closeFuture().await();
        } finally {

        }
    }
}