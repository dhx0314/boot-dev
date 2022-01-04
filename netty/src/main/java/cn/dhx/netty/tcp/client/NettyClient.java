package cn.dhx.netty.tcp.client;



import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class NettyClient {

    static final String HOST = "127.0.0.1";
    static final int PORT = 8899;
    private EventLoopGroup group;
    private Bootstrap b;
    private ChannelFuture channelFuture;
    private NettyClientInitializer nettyClientInitializer;


    public NettyClient() {
        nettyClientInitializer = new NettyClientInitializer();
        group = new NioEventLoopGroup();
        b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .handler(nettyClientInitializer);
    }

    public void connect() {
        try {
            this.channelFuture = b.connect(HOST, PORT).sync();
        } catch (InterruptedException e) {
            log.error("客户端连接服务端异常：" + e);
        }
    }

    public ChannelFuture getChannelFuture() {
        if (this.channelFuture == null) {
            this.connect();
        }
        if (!this.channelFuture.channel().isActive()) {
            this.connect();
        }
        return this.channelFuture;
    }

    public void close() {
        try {
            this.channelFuture.channel().closeFuture().sync();
            this.group.shutdownGracefully();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setMessage(String msg) throws InterruptedException {
//        ChannelFuture channelFuture = this.getChannelFuture();
//        channelFuture.channel().writeAndFlush(msg);
        channelFuture.channel().writeAndFlush(msg);
    }


    public static void main(String[] args) {
        try {

            NettyClient nettyClient = new NettyClient();
            nettyClient.setMessage("aa");
        } catch (Exception e) {
            log.error("异常：" + e);
        }
    }


}
