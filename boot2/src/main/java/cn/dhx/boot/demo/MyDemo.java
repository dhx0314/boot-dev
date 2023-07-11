package cn.dhx.boot.demo;

import cn.dhx.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author daihongxin
 * @create 2023/7/3 15:19
 */
@Slf4j
public class MyDemo {


    public static void main(String[] args) {

        User user = new User();
        user.setName("aa");
        ArrayList<User> users = new ArrayList<>();
        boolean add = users.add(user);

        User user1 = users.get(0);
        user1.setName("bb");
        users.remove(user1);
        System.out.println(users.size());

    }

    public static void fun1(User user) {

        synchronized (user) {
            log.info("name {}", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
