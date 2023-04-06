package cn.dhx.demo.boot;

import cn.dhx.demo.boot.udp2.server.UdpServer;
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




    @PostConstruct
    public void start() {
        ExecutorHelper.execute(()->{
            try {
                UdpServer.bind();
            } catch (Exception e) {
                log.error("error",e);
            }
        });

    }
}
