package cn.dhx.netty.boot.cache;

import cn.dhx.netty.boot.tcp.client.TcpClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TcpChannelUtil {


    private static TcpClient tcpClient;

    private static CopyOnWriteArrayList<ChannelHandlerContext> arrayList = new CopyOnWriteArrayList<>();

    public static void save(ChannelHandlerContext ctx) {
        log.info("tcp channel active");
        arrayList.clear();
        arrayList.add(ctx);
    }

    public static void send(String msg) {
        byte[] bytes = msg.getBytes();
        ByteBuf buffer = Unpooled.buffer(bytes.length);
        buffer.writeBytes(bytes);
        if (arrayList.size() < 0) {

            log.info("size "  );
            return;
//            tcpClient.fun1();
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        ChannelHandlerContext ctx = arrayList.get(0);
        log.info("send");
        ctx.writeAndFlush(buffer);

    }


    @Autowired
    public static void setTcpClient(TcpClient tcpClient) {
        TcpChannelUtil.tcpClient = tcpClient;
    }
}
