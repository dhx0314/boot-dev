package cn.dhx.boot.disruptor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/7/31 10:56
 */
@Slf4j
@Data
public class Event {
    private int id;
    private String name;

    // getters and setters
}

