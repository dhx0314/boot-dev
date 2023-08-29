package cn.dhx.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @Author daihongxin
 * @create 2023/8/29 16:47
 */
@Slf4j
@MyAnnotation("Hello, World!")
public class MyClass {


    @MyAnnotation("name world!")
    String name;

    public static void main(String[] args) throws NoSuchFieldException {
        // 获取MyClass类的注解
        MyAnnotation annotation = MyClass.class.getAnnotation(MyAnnotation.class);


        if (annotation != null) {
            System.out.println(annotation.value());  // 输出注解的值
        } else {
            System.out.println("注解不存在");
        }

        Class<MyClass> c1 = MyClass.class;
        Field f = c1.getDeclaredField("name");//先获得指定的属性
        MyAnnotation myAnnotation = f.getAnnotation(MyAnnotation.class);//通过属性,获得该注解
        System.out.println(myAnnotation.value());

    }
}
