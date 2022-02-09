package cn.dhx.nettyvoice.ali;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
@Slf4j
public class AliASR {


    public final static BlockingQueue<byte[]> pkgQueue = new LinkedBlockingQueue<>();



    public void start() {

        log.info("SpeechTranscriberDemo start");

        String appKey = "Wpiram4S7WXcyc6q";
        String token = "13f9cb36d093484b90ee4db1e7f4bd77";
        String url = "wss://nls-gateway.cn-shanghai.aliyuncs.com/ws/v1";
        String filepath="";


        new Thread(()->{
            SpeechTranscriberDemo demo = new SpeechTranscriberDemo(appKey, token, url);
            demo.process(filepath);
        }).start();

    }
}
