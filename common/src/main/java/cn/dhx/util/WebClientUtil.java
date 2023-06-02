package cn.dhx.util;

import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebClientUtil {
    private static final Map<String, WebClient> webClients = new ConcurrentHashMap<>();

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

}
