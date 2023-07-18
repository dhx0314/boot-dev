package cn.dhx.boot.delayqueue.zset;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author daihongxin
 * @create 2023/7/17 10:06
 */
@Slf4j
@RestController
public class ZSETOrderDelayController {


    @Autowired
    @Qualifier("ZSetOrderDelayService")
    private OrderDelayService orderDelayService;

    @GetMapping("zset/delay/add")
    public Object add() {
        orderDelayService.produce(UUID.randomUUID().toString());
        return "ok";
    }



}
