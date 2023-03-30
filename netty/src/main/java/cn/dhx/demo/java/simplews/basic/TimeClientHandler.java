package cn.dhx.demo.java.simplews.basic;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

/**
 * Created by wangdecheng on 24/05/2018.
 */

@Slf4j
public class TimeClientHandler extends ChannelInboundHandlerAdapter {


    private final ByteBuf firstMessage;

    public TimeClientHandler(){
        byte[] req = "Query Time Order".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        System.out.println("channelActive {}"+ctx.channel().id());
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("NOW is :" + body);
//        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        ctx.close();
    }
}
