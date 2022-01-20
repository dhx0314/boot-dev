package cn.dhx.nettyvoice.udpserver;

import cn.dhx.nettyvoice.tcpserver.TimeServer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;



@Slf4j
@Component
public class UdpServer {


    public void bind(int port)throws InterruptedException{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    // 主线程处理
                    .channel(NioDatagramChannel.class)
                    // 广播
                    .option(ChannelOption.SO_BROADCAST, true)
                    // 设置读缓冲区为2M
                    .option(ChannelOption.SO_RCVBUF, 2048 * 1024)
                    // 设置写缓冲区为1M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)
                    .handler(new ChannelInitializer<NioDatagramChannel>() {

                        @Override
                        protected void initChannel(NioDatagramChannel ch) {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new UdpServerHandler(port));
                        }
                    });


            ChannelFuture f = bootstrap.bind(port).sync();
            log.info("[{}] udp server 服务器正在监听......", port);
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }

    }

    @PostConstruct
    public void start() {
        int port=9001;
        int port2=9002;
        try {
            new Thread(()->{
                try {
                    new UdpServer().bind(port);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();

            new Thread(()->{
                try {
                    new UdpServer().bind(port2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
