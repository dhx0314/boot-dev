package cn.dhx.boot.aop.study;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author daihongxin
 * @create 2023/9/1 16:49
 */
@Slf4j
public class MyTest {

    //正常测试
    @Test
    public void test01(){
        //通过配置类启动容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        //用id取出业务逻辑类的bean
        MyServiceDemo myService = (MyServiceDemo) applicationContext.getBean("MyServiceDemo");
        //调用此bean的divide方法观察控制台的输出信息,其中传入的参数进行除法运算是正常的
        myService.divide(1, 1);

    }

    //故意传入错误的参数测试(除法运算时分母不能为0，但强行这样做康康会怎么样)
    @Test
    public void test02(){
        //通过配置类启动容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        //用id取出业务逻辑类的bean
        MyServiceDemo myService = (MyServiceDemo) applicationContext.getBean("MyServiceDemo");
        //调用此bean的divide方法观察控制台的输出信息,其中传入的分母参数为 0
        try{
            //分母故意传个 0 康康会不会执行切面类的异常通知方法
            myService.divide(1, 0);
        }catch (Exception e){

        }
    }

}
