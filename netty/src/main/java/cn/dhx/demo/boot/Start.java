package cn.dhx.demo.boot;

import cn.dhx.demo.boot.udp2.server.UdpServer;
import cn.dhx.demo.boot.udp2.server.UdpServer2;
import cn.dhx.util.ExecutorHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author daihongxin
 * @create 2023/4/6 14:32
 */

@Component
@Slf4j
public class Start {


    @Autowired
    private UdpServer2 udpServer2;


    @PostConstruct
    public void start() {

        try {
            UdpServer.bind();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        udpServer2.bootstrap();
//        ExecutorHelper.execute(()->{
//            try {
//                udpServer2.bind(7686);
//            } catch (Exception e) {
//                log.error("error",e);
//            }
//        });

    }
}
