package cn.dhx.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebfluxApplication {

    //声纹
    //http://10.188.45.24:5000/home/CallFSWSInt
    //业务
    //http://10.152.5.29:8091/agent/voiceprint/wvrquery.do?method=vocalPrintResult

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

}
