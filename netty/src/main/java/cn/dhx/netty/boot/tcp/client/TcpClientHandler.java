/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package cn.dhx.netty.boot.tcp.client;

import cn.dhx.netty.boot.cache.TcpChannelUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
@ChannelHandler.Sharable
public class TcpClientHandler extends ChannelInboundHandlerAdapter {


    @Autowired
    private TcpClient client;

//    private TcpClient tcpClient;
//
//
//    public TcpClientHandler(TcpClient tcpClient) {
//        this.tcpClient = tcpClient;
//    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("tcp channelActive id",ctx.channel().id());

        byte[] req = "aa".getBytes();
        ByteBuf firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
        ctx.writeAndFlush(firstMessage);
        TcpChannelUtil.save(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("Now is : " + body);
        log.info("Now is : " + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.info("tcp exceptionCaught id {}",ctx.channel().id());
        ctx.close();
//        tcpClient.fun1();


    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        ctx.close();

        log.info("tcp channelInactive id {}",ctx.channel().id());

//        client.fun1();
    }

}
