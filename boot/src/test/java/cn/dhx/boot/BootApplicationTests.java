package cn.dhx.boot;

import cn.dhx.boot.autoconfig.AppProp;
import cn.dhx.boot.autoconfig.AppProperties;
import cn.dhx.boot.config.Person;
//import cn.dhx.boot.ftp.FileUtil;
//import cn.dhx.boot.ftp.config.FtpConfigProperties;

import cn.dhx.boot.demo2.StuDemo;
import cn.dhx.boot.ftppool.FtpPool;

import cn.dhx.boot.httpd.Upload;
import cn.dhx.boot.kafka.KafkaProducerDemo;
import cn.dhx.boot.redis.DemoRedis;
//import cn.dhx.boot.thread2.StuDemo;
import cn.dhx.boot.thread2.Stu;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class BootApplicationTests {


    @Autowired
    DemoRedis demoRedis;

    @Autowired
    RestTemplate restTemplate;


    @Autowired
    private Stu stu;


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;




//
//    @Autowired
//    FileUtil fileUtil;


//    @Autowired
//    private TestObjectPool testObjectPool;

    @Autowired
    private FtpPool ftpPool;


    @Value("${time.cron}")
    private String interval;

    @Autowired
    private Person person;


    @Autowired
    private AppProperties appProperties;


    @Autowired
    ObjectFactory<StuDemo> stuDemo;

    @Autowired
    StuDemo stuDemosin;


    @Autowired
    private Upload upload;

    @Autowired
    private KafkaProducerDemo kafkaProducerDemo;


    @Test
    public void fun239aa47()  {
        for (int i = 0; i < 2; i++) {
            kafkaProducerDemo.send("aa");
        }
    }



    @Test
    public void fun23947() throws JsonProcessingException, InterruptedException {
//        Person person = new Person();
//        person.setAge(10);
//        person.setLastName("2213");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String string = objectMapper.writeValueAsString(person);
//        redisTemplate.opsForHash().put("map1","k1",string);
//        Map map1 = redisTemplate.opsForHash().entries("map1");
//        Object k1 = map1.get("k1");
//        System.out.println(k1);
//        System.out.println(k1.toString());


//        redisTemplate.opsForValue().set("str1", "1", 10, TimeUnit.SECONDS);
////        Thread.sleep(5);
//        TimeUnit.SECONDS.sleep(8);
//        Long str1 = redisTemplate.opsForValue().getOperations().getExpire("str1");
//        System.out.println(str1);

        Boolean str = redisTemplate.expire("str", 10, TimeUnit.SECONDS);
        System.out.println(str);
        Set keys = redisTemplate.keys("REC-AGENT*");
        System.out.println(keys.size());
    }





    @Test
    public void test2() throws IOException {
        long start = System.currentTimeMillis();
        List<String> keys = Lists.newArrayList();
        Cursor<String> cursor = scan(stringRedisTemplate, "*REC-AGENT*", 200);
        while (cursor.hasNext()){
            //找到一次就添加一次
            keys.add(cursor.next());
        }
        cursor.close();
        keys.forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


    private static Cursor<String> scan(StringRedisTemplate stringRedisTemplate, String match, int count){
        ScanOptions scanOptions = ScanOptions.scanOptions().match(match).count(count).build();
        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) stringRedisTemplate.getKeySerializer();
        return (Cursor) stringRedisTemplate.executeWithStickyConnection((RedisCallback) redisConnection ->
                new ConvertingCursor<>(redisConnection.scan(scanOptions), redisSerializer::deserialize));
    }
    @Test
    public void fun1weafe() throws InterruptedException {
        String key = "hash";
//        redisTemplate.opsForValue().set("str1", "2", Duration.ofSeconds(100));
//        TimeUnit.SECONDS.sleep(10);

//        redisTemplate.opsForValue().
        redisTemplate.opsForHash().put(key, "k1", "v1");
        redisTemplate.opsForHash().put(key, "k2", "v2");
        redisTemplate.opsForHash().put(key, "k3", "v3");
        redisTemplate.opsForHash().get(key, "k3");
        Map<Object, Object> hashmap = redisTemplate.opsForHash().entries(key);
//        Map<Object, Object> hashmap2 = redisTemplate.opsForHash().entries("key");
        hashmap.forEach((k,v)->{
            System.out.println(k+"---"+v);
        });
        List values = redisTemplate.opsForHash().values(key);
        values.forEach(x->{
            System.out.println(x);
        });


//        hashmap.forEach((k, v) -> {
//            System.out.println(k + " " + v);
//        });
//        Set<Object> keySet = hashmap.keySet();
//        ArrayList<Object> objects = new ArrayList<>(keySet);
//        int size = objects.size();
//        for (int i = 0; i < 100; i++) {
//            int number = (int)(Math.random()*size);
//            int a=number;
//            Object o = objects.get(a);
//            Object o1 = hashmap.get(o);
//            System.out.println(o1);
//        }



    }

    @Test
    public void fun1waef() {
        String s = null;
        try {

            String ss="11";
            System.out.println(ss);
            log.info("----"+ss);
            s.equals("2");
        } catch (Exception e) {

            e.printStackTrace();

            log.info("-----------------");
            log.info("----"+e.getCause().getMessage());
            log.info("===================");
        }
    }


    @Test
    public void fun1aaa() {

        System.out.println("fun3");
        String downPath = "http://172.16.2.144:8010/vox/a.wav";
        String upPath = "http://172.16.2.144:8010/vox/b.wav";
        upload.downAndUploadFile(downPath, upPath);

    }


    @Test
    public void a1q() {
        for (int i = 0; i < 5; i++) {
            StuDemo stuDemo = this.stuDemo.getObject();
            System.out.println(stuDemo);
            System.out.println(stuDemo.dataDemo);
        }

        System.out.println("--------------");
        for (int i = 0; i < 5; i++) {
            System.out.println(stuDemosin);
            System.out.println(stuDemosin.dataDemo);
        }
//        StuDemo object = stuDemo.getObject();
//        System.out.println(stuDemo);
//        System.out.println(object.dataDemo);
//        dataDemo dataDemo = stuDemo.getObject().dataDemo;
//        System.out.println(dataDemo);
//        System.out.println(stuDemosin);
//        System.out.println(stuDemosin.dataDemo);
//        StuDemo stuDemo = new StuDemo();
//        System.out.println(stuDemo.dataDemo);
//        StuDemo stuDemo1 = new StuDemo();
//        System.out.println(stuDemo1.dataDemo);

    }

    @Test
    public void fun1a() {
        List<AppProp> aesList = appProperties.getAesList();
        for (AppProp appProp : aesList) {
            System.out.println(appProp);
        }


    }


    @Test
    public void fun1rr() {
//        System.out.println(person);
        Map<String, Object> maps = person.getMaps();
        maps.forEach((k, v) -> {
            System.out.println(k + "  " + v);
        });
    }

    @Test
    public void fun1aa() {
        System.out.println(interval);
        String[] s = interval.split(" ");
        String s2 = s[1];
        String substring = s2.substring(s2.lastIndexOf("/") + 1);
        System.out.println("s        " + substring);
        for (String s1 : s) {
            System.out.println(s1);
        }
    }


    @Test
    public void a11() {
        for (int i = 0; i < 15; i++) {
            new Thread(() -> {
                FTPClient ftpClient = null;
                try {
                    ftpClient = ftpPool.borrowObject();
                    System.out.println(Thread.currentThread().getName() + "--- " + ftpClient);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    ftpPool.returnObject(ftpClient);
                }

            }).start();
        }
    }


//    @Test
//    public void test() {
//
//        for (int i = 0; i < 20; i++) {
//
//            new Thread(() -> {
//                TestObject testObject = null;
//                try {
//                    testObject = testObjectPool.borrowObject();
//                    //省略业务代码...
//                    System.out.println(Thread.currentThread().getName()+"-----   "+testObject);
////                    System.out.println(testObject);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    if (testObject != null) {
//                        //最终归还对象到对象池
//                        testObjectPool.returnObject(testObject);
//                    }
//                }
//            }).start();
//        }
//    }

//    @Test
//    public void fun2() {
//        try {
//            fileUtil.down();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }





    @Test
    public void fun1() {
        demoRedis.fun1();
    }


    @Test
    public void fun3() {

        String stationExistUrl = "http://172.16.2.144:8091/passive-recorder/stationExist";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("station", Integer.valueOf("1001"));
        String json = null;
        try {
            json = objectMapper.writeValueAsString(hashMap);
        } catch (JsonProcessingException e) {
            log.info("stationExist  json fail");
//            return Result.fail(ResultCode.RECORDER_STATION_INSERT_FAIL);
        }
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(stationExistUrl, HttpMethod.POST, request, String.class);
        System.out.println(exchange);
        System.out.println(exchange.getStatusCodeValue());
        System.out.println(exchange.getStatusCode());
        System.out.println(exchange.getBody());
        String body = exchange.getBody();
        try {
            JsonNode jsonNode = objectMapper.readTree(body);
            String returnCode = jsonNode.get("returnCode").asText();
            System.out.println(returnCode);
            if ("1".equals(returnCode)) {
                System.out.println("1-----");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

}
