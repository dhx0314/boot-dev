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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
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
                            ch.pipeline().addLast(tcpClientHandler);
                        }
                    });
            log.info("tcp connect  ");
            channelFuture = bootstrap.connect(host, port).sync();
            channel = channelFuture.channel();
            log.info("tcp connect success {}", channelFuture.toString());
            // 当代客户端链路关闭

            channelFuture.channel().closeFuture().sync();

        } catch (Exception e) {
            log.info("tcp connect exception", e);
        }
    }

    @PostConstruct
    public void startConnect() {
        log.info("----------startConnect");
        new Thread(() -> {
            this.connect(tcpHost, tcpPort);
        }).start();

    }



    public void fun1() {
        new Thread(()-> {
            log.info("tcp connect  ");
            try {
                channelFuture = bootstrap.connect(tcpHost, tcpPort).sync();
                channel = channelFuture.channel();
                log.info("tcp connect success {}", channelFuture.toString());
                // 当代客户端链路关闭
                channelFuture.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
