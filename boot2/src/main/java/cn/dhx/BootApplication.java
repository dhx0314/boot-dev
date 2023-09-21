package cn.dhx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author daihongxin
 * @create 2023/3/3 17:00
 */
@SpringBootApplication
@EnableScheduling
//@ServletComponentScan
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
