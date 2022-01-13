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

import cn.dhx.netty.boot.cache.CacheUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CopyOnWriteArrayList;


/**
 * @author lilinfeng
 * @version 1.0
 * @date 2014年2月14日
 */

@Slf4j
//@Component
public class TcpClientHandler extends ChannelInboundHandlerAdapter {

//    private static final log log = log
//            .getlog(TcpClientHandler.class.getName());

    private final ByteBuf firstMessage;

    private CopyOnWriteArrayList<ChannelHandlerContext> arrayList = new CopyOnWriteArrayList<>();

//    public String sendMessage(String msg) {
//        byte[] bytes = msg.getBytes();
//        ByteBuf buffer = Unpooled.buffer(bytes.length);
//        buffer.writeBytes(bytes);
//
//        return "ok";
//    }

    /**
     * Creates a client-side handler.
     */
    public TcpClientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("channelActive");
        CacheUtil.save(ctx);
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("Now is : " + body);
        log.info("Now is : " + body);
        CacheUtil.fun1(body);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 释放资源
        log.warn("Unexpected exception from downstream : "
                + cause.getMessage());

        log.info("exceptionCaught id {}",ctx.channel().id());
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("channelInactive id {}",ctx.channel().id());
    }

}
