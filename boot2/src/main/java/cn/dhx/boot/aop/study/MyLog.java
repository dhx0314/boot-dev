package cn.dhx.boot.aop.study;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Author daihongxin
 * @create 2023/9/1 16:49
 */
@Slf4j
@Aspect
public class MyLog {


    //Aop一般有以下常用注解:
    //
    //@Aspect: 该注解是把此类声明为一个切面类。
    //
    //@Before: 该注解是声明此方法为前置通知 (目标方法执行之前就会先执行被此注解标注的方法)
    //
    //@After: 该注解是声明此方法为后置通知 (目标方法执行完之后就会执行被此注解标注的方法)
    //
    //@AfterReturning: 该注解是声明此方法为返回通知 (目标方法正常执行返回后就会执行被此注解标注的方法)
    //
    //@AfterThrowing: 该注解是声明此方法为异常通知 (目标方法在执行出现异常时就会执行被此注解标注的方法)
    //
    //@Around: 该注解是环绕通知是动态的,可以在前后都设置执行
    //
    //@PointCut: 该注解是声明一个公用的切入点表达式(通知行为的注解的都可以直接拿来复用)
    //
    //如果是注解式开发还会用到@EnableAspectJAutoProxy: 该注解是声明这个配置类使用注解式的AOP

    //抽取公共的切入点表达式
    //该表达式表明MyService类下的所有方法都加上aop功能
    @Pointcut("execution(public int cn.dhx.boot.aop.study.MyService.*(..))")
    public void pointCut() {
    }

    ;

    //在目标方法之前切入
    //复用上面定义的pointCut()方法上的切入点表达式
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        //获取目标方法名 (单纯取出来而已下面没有用到这个变量)
        String methodName = joinPoint.getSignature().getName();
        //获取目标方法参数列表 （下面有输出这个）
        Object[] args = joinPoint.getArgs();
        log.info("Before--除法运行. methodName {}  参数列表是: {}",methodName, Arrays.asList(args));
    }

    //在目标方法之后切入
    @After("pointCut()")
    public void logEnd() {
        log.info("After--除法结束...");
    }

    //在目标方法正常返回切入
    //result是目标方法正常返回的返回值
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        log.info("AfterReturning--除法正常返回...运行结果: { " + result + " }");
    }

    //在目标方法异常时切入
    //exception是目标方法异常的异常对象
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        log.error("AfterThrowing--除法异常...异常信息", exception);
    }


    @Around(value = "pointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        log.info("环绕通知 methodName {} args {}", methodName, args);
        try {
            log.info("环绕通知-->目标对象方法执行之前");
            //目标对象（连接点）方法的执行
            result = joinPoint.proceed();
            log.info("环绕通知-->目标对象方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.info("环绕通知-->目标对象方法出现异常时");
        } finally {
            log.info("环绕通知-->目标对象方法执行完毕");
        }
        return result;
    }

}




