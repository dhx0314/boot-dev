package cn.dhx.bootdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author : zhouhailin
 */
@Slf4j
@Aspect
@Component
public class LogAspect {


    /**
     * log pointcut
     */
    @Pointcut("@annotation(cn.dhx.bootdemo.annotation.Log)")
    public void log() {
    }

    /**
     * 前置通知，执行目标方法之前，执行的操作
     *
     * @param joinPoint 切面对象
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        doLog(joinPoint);
    }

    /**
     * 日志输出
     *
     * @param joinPoint 切面对象
     */
    private void doLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        StringBuilder sb = new StringBuilder();
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < parameterNames.length; i++) {
            sb.append(parameterNames[i]).append(" : ").append(args[i]).append(", ");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 2);
        }
        getLogger(joinPoint).info("[log] [{}] {}", joinPoint.getSignature().getName(), sb);
    }

    /**
     * 根据切面的方法获取Logger
     *
     * @param joinPoint 切面对象
     * @return logger
     */
    private Logger getLogger(JoinPoint joinPoint) {
        return LoggerFactory.getLogger(joinPoint.getTarget().getClass());
    }

}
