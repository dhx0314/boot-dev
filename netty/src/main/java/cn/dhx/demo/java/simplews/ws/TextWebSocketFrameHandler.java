package cn.dhx.demo.java.simplews.ws;

import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@Slf4j
//处理文本协议数据，处理TextWebSocketFrame类型的数据，websocket专门处理文本的frame就是TextWebSocketFrame
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{

    private static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //读到客户端的内容并且向客户端去写内容
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("收到消息："+msg.text());

        Channel channel = ctx.channel();
        //单个回应
//        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务时间："+ msg.text().toUpperCase()+" "+ LocalDateTime.now()));
        //全部channle都推送
//        channelGroup.writeAndFlush(new TextWebSocketFrame("服务时间："+ msg.text().toUpperCase()+" "+ LocalDateTime.now()));

    }

    //每个channel都有一个唯一的id值
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //打印出channel唯一值，asLongText方法是channel的id的全名
        System.out.println("handlerAdded："+ctx.channel().id().asLongText());
        channelGroup.add(ctx.channel());
        System.out.println("channelGroup"+ channelGroup.size());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("Channel {} became active, remote address {}.", ctx.channel(), ctx.channel().remoteAddress());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("Channel {} became inactive, remote address {}.", ctx.channel(), ctx.channel().remoteAddress());
        ctx.channel().close().addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                log.warn("Close channel {} because of e,result is {}", ctx.channel(), future.isSuccess());
            }
        });


    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved：" + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常发生");
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.ALL_IDLE) { // 触发了空闲事件
                Channel channel = ctx.channel();
                ChannelId channelId = channel.id();
                System.out.println(channel);
            } else if (event.state() == IdleState.READER_IDLE) {
                log.info("READER_IDLE");
                System.out.println("READER_IDLE");
//                ctx.channel().writeAndFlush(new TextWebSocketFrame("服务时间："+" "+ LocalDateTime.now()));
            } else if (event.state() == IdleState.WRITER_IDLE) {
                System.out.println("WRITER_IDLE");
                log.info("WRITER_IDLE");
            }
        }
    }


}
