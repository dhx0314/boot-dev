package cn.dhx.reflect;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author daihongxin
 * @create 2023/7/7 11:10
 */
@Slf4j
public class Demo2 {




    @Test
    public void fun1() throws Exception {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("io/prop.properties");
        properties.load(fileInputStream);
        fileInputStream.close();
        System.out.println(properties);
        String classname = properties.getProperty("classname");
        String method = properties.getProperty("method");

        Class<?> aClass = Class.forName(classname);
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance();

        Method method1 = aClass.getMethod(method);
        method1.setAccessible(true);
        method1.invoke(o);
    }
}
