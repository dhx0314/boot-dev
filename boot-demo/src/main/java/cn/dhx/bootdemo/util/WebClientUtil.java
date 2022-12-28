package cn.dhx.bootdemo.util;

import cn.dhx.bootdemo.demo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
public class WebClientUtil {
    private static final Map<String, WebClient> webClients = new ConcurrentHashMap<>();

    private static final int TIMEOUT = 5000;

    public static WebClient create(String url) {
        if (!webClients.containsKey(url)) {
            synchronized (webClients) {
                if (!webClients.containsKey(url)) {
                    webClients.put(url,
                            WebClient.builder()
                                    .exchangeStrategies(ExchangeStrategies.builder()
                                            .codecs(config ->
                                                    config.defaultCodecs().maxInMemorySize(10 * 1024 * 1024))
                                            .build())
                                    .baseUrl(url)
                                    .build());
                }
            }
        }
        return webClients.get(url);
    }


    public static JsonResult post(String url, Object object) {

        JsonResult jsonResult=new JsonResult(true,"text");
        try {
            WebClientUtil.create(url)
                    .post()
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(object)
                    .retrieve()
                    .bodyToMono(JsonResult.class)
                    .timeout(Duration.ofMillis(TIMEOUT))
                    .doOnError(e -> {
                        log.error("post error doOnError");
                    })
                    .subscribe(res -> {
                        if (res != null && res.isSuccess()) {
                            log.info("success {}", res.toString());
                        } else {
                            log.info("error {}!", res.toString());
                        }
                    });
        } catch (Exception e) {
            log.error("post error Exception",e);
        }
        return jsonResult;
    }



    public static JsonResult post2(String url, Object object) {

        JsonResult jsonResult=new JsonResult(true,"text222222");
        try {
            JsonResult block = WebClientUtil.create(url)
                    .post()
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(object)
                    .retrieve()
                    .bodyToMono(JsonResult.class)
                    .timeout(Duration.ofMillis(TIMEOUT))
                    .block();
            return block;
        } catch (Exception e) {
            log.error("post error Exception",e);
        }
        return jsonResult;
    }

}
