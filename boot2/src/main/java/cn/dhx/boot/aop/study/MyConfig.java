package cn.dhx.boot.aop.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author daihongxin
 * @create 2023/9/1 16:48
 */
@Slf4j
@Configuration
@EnableAspectJAutoProxy
public class MyConfig {

    //向容器中注册: 日子切面类
    @Bean
    public MyLog myLog(){
        return new MyLog();
    }

    //向容器中注册: 业务逻辑类
    @Bean
    public MyServiceDemo myServiceDemo(){
        return new MyServiceDemo();
    }

}
