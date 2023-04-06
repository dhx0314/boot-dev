package cn.dhx.demo.boot.udp2.server;

/**
 * @Author daihongxin
 * @create 2023/4/3 11:07
 */

import cn.dhx.demo.boot.udp2.server.UdpServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/4/3 11:07
 */

@Slf4j
@Component
public final class UdpServer2 {

    Bootstrap bootstrap;

    private static final int PORT = Integer.parseInt(System.getProperty("port", "7686"));


    public void bind(int port) {
        try {
            Channel channel = bootstrap.bind(port).sync().channel();
            log.info("channel {}",channel);
            channel.closeFuture().sync();
        } catch (Exception e) {
            log.error("bind error ",e);
        }
    }

    public Bootstrap bootstrap() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioDatagramChannel.class)
                    // 设置读缓冲区为 10M
                    .option(ChannelOption.SO_RCVBUF, 1024 * 1024 * 10)
                    // 设置写缓冲区为1M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)
                    //解决最大接收2048个字节
                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(65535))
                    .handler(new UdpServerHandler());
            return bootstrap;

        } catch (Exception e) {

        }
        return bootstrap;
    }
}