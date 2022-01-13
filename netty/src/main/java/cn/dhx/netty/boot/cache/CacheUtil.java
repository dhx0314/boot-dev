package cn.dhx.netty.boot.cache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class CacheUtil {

    private static   CopyOnWriteArrayList<ChannelHandlerContext> arrayList = new CopyOnWriteArrayList<>();

    public static  void save(ChannelHandlerContext ctx) {
        log.info("add");
        arrayList.add(ctx);
    }

    public static void send(String msg) {
        byte[] bytes = msg.getBytes();
        ByteBuf buffer = Unpooled.buffer(bytes.length);
        buffer.writeBytes(bytes);
        ChannelHandlerContext ctx = arrayList.get(0);
        ctx.writeAndFlush(buffer);
    }


    public static void fun1(String message) {
        log.info("--"+message);
    }
}
