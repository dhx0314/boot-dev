package cn.dhx.nettyvoice.ali;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class AliASR {


    public final static BlockingQueue<byte[]> pkgQueue = new LinkedBlockingQueue<>();


    @PostConstruct
    public void start() {

        String appKey = "Wpiram4S7WXcyc6q";
        String token = "942dab023e5e41d8bc19fc8cf70bb862";
        String url = "wss://nls-gateway.cn-shanghai.aliyuncs.com/ws/v1";
        String filepath="";
        SpeechTranscriberDemo demo = new SpeechTranscriberDemo(appKey, token, url);

        new Thread(()->{
            demo.process(filepath);
        }).start();

//        demo.shutdown();
    }
}
