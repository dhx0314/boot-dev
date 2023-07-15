package cn.dhx.mq.rabbitmq.java.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/7/15 17:08
 */
@Slf4j
public class RabbitConstant {

    public static final String QUEUE_HELLO_WORLD = "helloworld";
    public static final String QUEUE_SMS = "sms";
    public static final String EXCHANGE_WEATHER = "weather";
    public static final String EXCHANGE_WEATHER_ROUTING = "weather_routing";
    public static final String QUEUE_BAIDU = "baidu";
    public static final String QUEUE_SINA = "sina";
    public static final String EXCHANGE_WEATHER_TOPIC = "weather_topic";
}
