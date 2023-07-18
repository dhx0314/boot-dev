package cn.dhx.boot.delayqueue.jvm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author daihongxin
 * @create 2023/7/17 10:06
 */
@Slf4j
@RestController
public class OrderDelayController {


    @Autowired
    private OrderDelayService orderDelayService;

    @GetMapping("delay/add")
    public Object add() {
        orderDelayService.addObject();
        return "ok";
    }



}
