package cn.dhx.reflect.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author daihongxin
 * @create 2023/9/1 10:05
 */
@Slf4j
public class MyInterceptor implements MethodInterceptor {


    private Object target;

    public MyInterceptor(Object target) {
        this.target = target;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        // 注意这里是调用 invokeSuper 而不是 invoke，否则死循环，
        // methodProxy.invokesuper执行的是原始类的方法，method.invoke执行的是子类的方法
        after();
        return result;
    }

    private void before() {
       log.info("before");
    }

    private void after() {
        log.info("after");
        log.info("---------------");
    }

}
