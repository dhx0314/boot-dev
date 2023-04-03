package cn.dhx.jvm.ClassLoader02;

import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/4/1 21:50
 */
public class GetClassLoader {


    @Test
    public void get() {
//        获得当前类的ClassLoader
        Class<GetClassLoader> getClassLoaderClass = GetClassLoader.class;
        ClassLoader classLoader = getClassLoaderClass.getClassLoader();
        System.out.println(classLoader);

//        获得当前线程上下文的ClassLoader
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
//        获得系统的classLoader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

//        获取扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

    }
}
