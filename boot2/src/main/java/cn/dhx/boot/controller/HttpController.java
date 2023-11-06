package cn.dhx.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author daihongxin
 * @create 2023/11/4 10:08
 */
@Slf4j
@RestController
public class HttpController {


    @GetMapping("/test1")
    public void test1(String username, String password, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        // 创建cookie并设置kv对
        Cookie cookie = new Cookie("key", "value");
        cookie.setMaxAge(60 * 60 * 24);        // 设置存活时间
        // 给响应体添加上cookie
        response.addCookie(cookie);
    }
}
