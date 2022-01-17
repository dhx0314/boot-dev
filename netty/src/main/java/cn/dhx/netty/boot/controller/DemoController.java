package cn.dhx.netty.boot.controller;


import cn.dhx.netty.boot.cache.TcpChannelUtil;
import cn.dhx.netty.boot.tcp.client.TcpClient;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

@RestController
@Slf4j
public class DemoController {

    @Autowired
    private TcpClient tcpClient;

    @Autowired
    private TcpChannelUtil tcpChannelUtil;

    @GetMapping("/hi/{msg}")
    public Object fun1(@PathVariable("msg") String msg) {
//        timeClientHandler.sendMessage(msg);
//        TcpChannelUtil.send(msg);

        tcpChannelUtil.OpenAudioStream();
        return "0k";
    }

    @GetMapping("/hi2")
    public Object fun12() {

        ChannelFuture channelFuture = tcpClient.getChannelFuture();
        boolean success = channelFuture.isSuccess();
        boolean active = channelFuture.channel().isActive();
        log.info("success {}", success);
        log.info("channel {}", active);
        log.info("channel2 {}", tcpClient.getChannel().isActive());
        if (active) {
            channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer("AA".getBytes(StandardCharsets.UTF_8)));
        } else {
            tcpClient.doConnect();
        }


        return "0k";
    }


}
