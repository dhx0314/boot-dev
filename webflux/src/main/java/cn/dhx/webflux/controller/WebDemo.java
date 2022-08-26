package cn.dhx.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashMap;

@RestController
@Slf4j
public class WebDemo {

    @GetMapping("/mono")
    public Mono<HashMap> map() {
//        Mono.create()
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("k1","v1");

        return Mono.just(hashMap);
    }


    public void funmono() {
        String url = "http://127.0.0.1:8088/mono";
        WebClient.create(url)
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(3))
                .doOnError(x -> {
                    System.out.println("----------------------------");
//                        System.out.println(x);
                    System.out.println("----------------------------");
                })
                .doOnSuccess(x->{
                    log.info("success {}",x);
                })

                .subscribe(x -> {
            log.info(x);
        });
    }

    public void funmono2() {
        String url = "http://127.0.0.1:8088/mono";
        String block = WebClient.create(url)
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(x -> {
                    System.out.println("----------------------------");
//                        System.out.println(x);
                    System.out.println("----------------------------");
                }).block();
        log.info(block);
    }

    public void test(){
//        HashMap<String, String> pushHashMap = new HashMap<>();
//        result = WebClient.create(url)
//                .post()
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(pushHashMap)
//                .retrieve()
//                .bodyToMono(PushResult.class)
//                .timeout(Duration.ofMillis(TIMEOUT))
//                .block();
    }

}
