package cn.dhx.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class WebController {

    @PostMapping("/mono")
    public Mono<HashMap> map(@RequestBody String s) {
        log.info("s {}",s);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("k1","v1");
        hashMap.put("k2","v2");
        return Mono.just(hashMap);
    }


    @GetMapping("/header")
    public Mono<HashMap> map2(@RequestHeader Map<String, String> headers) {

//        log.info("s {}",s);

        headers.forEach((key,value)->{
            log.info("key {},value{}",key,value);
        });

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("k1","v1");
        hashMap.put("k2","v2");
        return Mono.just(hashMap);
    }




    @GetMapping("/hello")
    public Mono<HashMap> hello() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("k1","v1");
        hashMap.put("k2","v2");
        return Mono.just(hashMap);
    }

    @GetMapping("/user/{id}/{name}")
    public Mono<String> user(@PathVariable("id") String id, @PathVariable("name") String name) {
        log.info("id {} name {}",id,name);
        return Mono.just("ok");
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
