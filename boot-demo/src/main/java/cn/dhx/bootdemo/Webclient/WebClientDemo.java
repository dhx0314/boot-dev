package cn.dhx.bootdemo.Webclient;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

//@Service
@RestController
@Slf4j
public class WebClientDemo {

    volatile List<String> availableSwitchList = new ArrayList<>();

    private final static String uri = "";


    @Test
    public void testExchange() {
        Mono<ClientResponse> clientResponseMono = WebClient
                .create()
                .get()
                .uri("http://127.0.0.1:8088/hello")
                .exchange();
        ClientResponse clientResponse = clientResponseMono.block();
        //响应头
        ClientResponse.Headers headers = clientResponse.headers();
        //响应状态
        HttpStatus httpStatus = clientResponse.statusCode();
        //响应状态码
        int rawStatusCode = clientResponse.rawStatusCode();
        //响应体
        Mono<String> mono = clientResponse.bodyToMono(String.class);
        String body = mono.block();
        log.info("headers {}", headers.toString());
        log.info("httpStatus {}", httpStatus);
        log.info("rawStatusCode {}", rawStatusCode);
        log.info("mono body {}", body);
    }


    @Test
    public void testGet() {
        String url = "http://127.0.0.1:8088/user/{id}/{name}";
        String id = "123";
        String name = "boss";
        Mono<String> mono = WebClient.create()
                .get()
                .uri(url, id, name)
                .retrieve()
                .bodyToMono(String.class);
        String result = mono.block();
        log.info("result {}", result);
    }


    @Test
    public void testClient() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("k1", "v1");
        hashMap.put("k2", "v2");
        String uri = "http://127.0.0.1:8088/mono";
        WebClient.create(uri)
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(hashMap)
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(5))
                .doOnError(e -> {
                    log.error("[{}] deviceId [{}] ERROR post start MRCP request [{}]!", e);
                })
                .subscribe(res -> {
                    if (res != null) {
                        log.info("success {} ", res.toString());
                    } else {
                        log.info("fail ");
                    }
                });

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }























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
        String url = "http://127.0.0.1:8088/test1";
        Mono<String> stringMono = WebClient.create(url)
                .post()
                .retrieve()
                .bodyToMono(String.class);
        System.out.println(stringMono.block());
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }


    public void fun2watae() {
        String url = "http://127.0.0.1:8088/test2";
        WebClient.create(url)
                .post()
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(x -> {
                    System.out.println("----------------------------");
//                        System.out.println(x);
                    System.out.println("----------------------------");
                }).subscribe(x -> {
                    log.info(x);
                });
    }


    @GetMapping("hi14")
    public String fun22aa() throws InterruptedException {

        System.out.println("start");


//        HashSet<String> strings = new HashSet<>();
        CopyOnWriteArraySet<String> strings = new CopyOnWriteArraySet<>();

        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                String url = "http://127.0.0.1:8088/test2";
                int finalI = i;
                WebClient.create(url)
                        .post()
                        .retrieve()
                        .bodyToMono(String.class)
                        .doOnError(x -> {
                            System.out.println("----------------------------");
                            countDownLatch.countDown();
                            System.out.println("----------------------------");
                        }).subscribe(x -> {
                            log.info(x);
                            strings.add("1--" + finalI);
                            countDownLatch.countDown();

                        });
            } catch (Exception e) {
                log.info("-----tttttttttttttttt---------------------");
                System.out.println("-----e------------------");
            } finally {
//            log.info("-------finally--------------------");
            }
        }
        log.info("---------------------------");
        countDownLatch.await();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                log.info("---" + availableSwitchList.size());
            }
        }).start();

        Thread.sleep(2);

        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println(strings.size() + "------------------");
//        availableSwitchList=new ArrayList<>(strings);
        availableSwitchList.clear();
        availableSwitchList.addAll(strings);
        System.out.println(availableSwitchList.size());
        return "0k";
    }


    @GetMapping("hi2")
    public String fun2() {

        System.out.println("start");

        try {

//            int i=1/0;
            String url = "http://127.0.0.1:80880/test2";
            WebClient.create(url)
                    .post()
                    .retrieve()
                    .bodyToMono(String.class)
                    .doOnError(x -> {
                        System.out.println("----------------------------");
//                        System.out.println(x);
                        System.out.println("----------------------------");
                    }).subscribe(x -> {
                        log.info(x);
                    });
        } catch (Exception e) {
            log.info("-----tttttttttttttttt---------------------");
            System.out.println("-----e------------------");
        } finally {
//            log.info("-------finally--------------------");
        }
        log.info("---------------------------");
//        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            log.info("i :"+ i);
//        }
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
        String url = "http://127.0.0.1:8088/test3";
        Mono<String> stringMono = WebClient.create(url)
                .post()
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(x -> {
                    System.out.println("----------" + x);
                    System.out.println(x.getMessage());
                })
                .onErrorReturn("error3");
//        System.out.println(stringMono.block());
        System.out.println("----------------1");
        stringMono.subscribe(x -> {
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
        String url = "http://127.0.0.1:8088/test3";
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
        flux.subscribe(x -> {
            System.out.println(x);

        });
        System.out.println("---------------------------------");
        return "ok";
    }

}
