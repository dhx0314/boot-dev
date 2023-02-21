package cn.dhx.bootdemo.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by lmb on 2018/9/5.
 */
@Aspect
@Component
@Slf4j
public class WebLogAcpect {


    /**
     * 定义切入点，切入点为com.example.aop下的所有函数
     */
//    @Pointcut("execution(public * cn.dhx.bootdemo.controller..*.*(..))")
//    public void webLog() {
//    }
    @Pointcut("@annotation(cn.dhx.bootdemo.annotation.Log)")
    public void webLog() {
    }

    /**
     * 前置通知：在连接点之前执行的通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        getLogger(joinPoint).info("URL : " + request.getRequestURL().toString());
        getLogger(joinPoint).info("HTTP_METHOD : " + request.getMethod());
        getLogger(joinPoint).info("IP : " + request.getRemoteAddr());
        getLogger(joinPoint).info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        getLogger(joinPoint).info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
        // 处理完请求，返回内容
        getLogger(joinPoint).info("RESPONSE : " + ret);
    }

    private Logger getLogger(JoinPoint joinPoint) {
        return LoggerFactory.getLogger(joinPoint.getTarget().getClass());
    }
}