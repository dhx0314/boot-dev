package cn.dhx.webflux.Webclient;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.crypto.spec.PSource;
import java.util.concurrent.TimeUnit;

//@Service
@RestController
@Slf4j
public class WebClientDemo {

    @GetMapping("hi1")
    public void fun1() {
//        WebClient webClient = WebClient.create();
//
//        Mono<String> mono = webClient
//                .get() // 发送GET 请求
//                .uri("http://jsonplaceholder.typicode.com/posts/1")  // 请求路径
//                .retrieve()    // 获取响应结果
//                .bodyToMono(String.class); //响应数据类型转换
//
//        System.out.println("=====" + mono.block());
        System.out.println("start");
        String url="http://127.0.0.1:8088/test1";
        Mono<String> stringMono = WebClient.create(url)
                .post()
                .retrieve()
                .bodyToMono(String.class);
        System.out.println(stringMono.block());
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }


    @GetMapping("hi2")
    public String fun2() {

        System.out.println("start");

        String url="http://127.0.0.1:8088/test2";
         WebClient.create(url)
                .post()
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(x->{
                    System.out.println("----------------------------");
                    System.out.println(x);
                    System.out.println("----------------------------");
                }).subscribe(x->{
                   log.info(x);
                });

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("i :"+ i);
        }
        return "0k";
    }

    public void fun3() {
        WebClient webClient = WebClient.create();
        Mono<String> mono = webClient.get().uri("https://www.baidu.com").retrieve().bodyToMono(String.class);
        mono.subscribe(System.out::println);
        mono.subscribe(s -> {
            System.out.println(s);
        });
    }


    @GetMapping("hi3")
    public String fun4() {
        System.out.println("start");
        String url="http://127.0.0.1:8088/test3";
        Mono<String> stringMono = WebClient.create(url)
                .post()
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(x-> {
                    System.out.println("----------"+x);
                    System.out.println(x.getMessage());
                })
                .onErrorReturn("error3");
//        System.out.println(stringMono.block());
        System.out.println("----------------1");
        stringMono.subscribe(x->{
            System.out.println(x);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode jsonNode = objectMapper.readTree(x);
                String s = jsonNode.get("a").asText();
                System.out.println("----------------------");
                System.out.println(s);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        System.out.println("---------------------------------");
        return "ok";
    }

    @GetMapping("hi4")
    public String fun5() {
        System.out.println("start");
        String url="http://127.0.0.1:8088/test3";
        Flux<Object> flux = WebClient.create(url)
                .post()
                .retrieve()
                .bodyToFlux(Object.class)
                .doOnError(x -> {
                    System.out.println("----------" + x);
                    System.out.println(x.getMessage());
                }).onErrorReturn("error3");
//        System.out.println(stringMono.block());
        System.out.println("----------------1");
//        stringMono.subscribe(x->{
//            System.out.println(x);
//        });
        flux.subscribe(x->{
            System.out.println(x);

        });
        System.out.println("---------------------------------");
        return "ok";
    }

}
