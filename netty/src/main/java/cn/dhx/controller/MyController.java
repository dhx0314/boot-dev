package cn.dhx.controller;

import cn.dhx.nio.filechannel.FileChannelDemo2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author daihongxin
 * @create 2023/6/6 9:51
 */
@Slf4j
@RestController
public class MyController {


    @GetMapping("start")
    public void start() {
        FileChannelDemo2.readWriteAllocate();
    }


    @GetMapping("start2")
    public void start2() {
        FileChannelDemo2.readWriteAllocateDirect();
    }
}
