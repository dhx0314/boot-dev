//package cn.dhx.boot.demo;
//
//import org.springframework.http.MediaType;
//
//import java.time.Duration;
//import java.util.HashMap;
//
//public class Demo03 {
//
//    public static void main(String[] args) {
//        System.out.println("---------------");
//        fu1n();
//        System.out.println("---------------");
//        System.out.println("-------waerwa--------");
//
//    }
//
//    public static void fu1n() {
//
//            HashMap<String, String> request = new HashMap<>();
//
//            WebClientUtil.create(stopUrl)
//                    .post()
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .bodyValue(request)
//                    .retrieve()
//                    .bodyToMono(JsonResult.class)
//                    .timeout(Duration.ofMillis(TIMEOUT))
//                    .doOnError(e -> {
//                        log.error("[{}] deviceId [{}] ERROR post stop MRCP request [{}]!", callId, deviceId, e);
//                    })
//                    .subscribe(res -> {
//                        if (res != null && res.isSuccess()) {
//                            log.info("[{}] deviceId [{}] SUCCESS post stop MRCP  request.", callId, deviceId);
//                        } else {
//                            log.error("[{}] deviceId [{}]FAILED post stop MRCP request!  response: {}!", callId, deviceId, res);
//                        }
//                    });
//        }
//    }
//}
