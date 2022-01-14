package cn.dhx.netty.boot.controller;


import cn.dhx.netty.boot.cache.TcpChannelUtil;
import cn.dhx.netty.boot.tcp.client.TcpClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@Slf4j
public class DemoController {

    @Autowired
    private  TcpClient tcpClient;

    @GetMapping("/hi/{msg}")
    public Object fun1(@PathVariable("msg") String msg) {
//        timeClientHandler.sendMessage(msg);
        TcpChannelUtil.send(msg);
        return "0k";
    }

    @GetMapping("/hi2")
    public Object fun12() {
        tcpClient.fun1();
        return "0k";
    }


}
