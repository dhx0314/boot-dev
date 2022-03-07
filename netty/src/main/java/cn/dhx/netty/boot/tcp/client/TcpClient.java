/*
 * Copyright 2013-2018 Lilinfeng.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.dhx.netty.boot.tcp.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
@Data
public class TcpClient {

    @Value("${tcp.host}")
    private String tcpHost;

    @Value("${tcp.port}")
    private int tcpPort;

    private EventLoopGroup group;

    private Bootstrap bootstrap;

    private ChannelFuture channelFuture;

    private Channel channel;

    @Autowired
    private TcpClientHandler tcpClientHandler;
//
//    @Autowired
//    private TcpDecoder tcpDecoder;


    public void connect(String host, int port) {
        try {
            // 配置客户端NIO线程组
            group = new NioEventLoopGroup();
            bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    //禁用了Nagle算法,允许小包的发送
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(new TcpDecoder());
                            ch.pipeline().addLast(tcpClientHandler);
                        }
                    });
            log.info("tcp connect  ");
            doConnect();
        } catch (Exception e) {
            log.info("tcp connect exception", e);
        }
    }

    @PostConstruct
    public void startTcpConnect() {
        log.info("start tcp connect");
        new Thread(() -> {
            this.connect(tcpHost, tcpPort);
        }).start();

    }

    public void doConnect() {
        log.info("channel {}",channel);
        if (channel != null && channel.isActive()) {
            return;
        }
//        channelFuture = bootstrap.connect("127.0.0.1", 8899);
        channelFuture = bootstrap.connect(tcpHost, tcpPort);
        channelFuture.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture futureListener) throws Exception {
                if (futureListener.isSuccess()) {
                    log.info("channel set");
                    channel = futureListener.channel();
                    System.out.println("Connect to tcp server successfully!");
                } else {
                    System.out.println("Failed to connect to  tcp server, try connect after 5s");
                    futureListener.channel().eventLoop().schedule(() -> {
                        doConnect();
                    }, 5, TimeUnit.SECONDS);
                }
            }
        });
    }


    public void fun1() {
        new Thread(() -> {
            log.info("tcp connect  ");
            try {
                channelFuture = bootstrap.connect(tcpHost, tcpPort).sync();
                channel = channelFuture.channel();
                log.info("tcp connect success {}", channelFuture.toString());
                // 当代客户端链路关闭
//                channelFuture.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
