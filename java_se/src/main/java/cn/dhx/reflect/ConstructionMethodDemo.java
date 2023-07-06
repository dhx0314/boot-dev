package cn.dhx.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

/**
 * @Author daihongxin
 * @create 2023/7/6 10:38
 */
@Slf4j
public class ConstructionMethodDemo {


    //        Class类中用于获取构造方法的方法
    //            Constructor<?>[] getConstructors()                                返回所有公共构造方法对象的数组
    //            Constructor<?>[] getDeclaredConstructors()                        返回所有构造方法对象的数组
    //            Constructor<T> getConstructor(Class<?>... parameterTypes)         返回单个公共构造方法对象
    //            Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 返回单个构造方法对象
    //
    //
    //        Constructor类中用于创建对象的方法
    //            T newInstance(Object... initargs)                                 根据指定的构造方法创建对象
    //            setAccessible(boolean flag)                                       设置为true,表示取消访问检查

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("cn.dhx.reflect.Student");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("---------------------------------------");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }


        System.out.println("-------------");
        Constructor<?> constructor = aClass.getConstructor(String.class);
        System.out.println(constructor);

        Constructor<?> constructor1 = aClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(constructor1);
        constructor1.setAccessible(true);
        Student instance = (Student) constructor1.newInstance("张三", 1);
        System.out.println(instance.toString());




        int modifiers1 = constructor.getModifiers();
        System.out.println(modifiers1);


        int parameterCount = constructor1.getParameterCount();
        System.out.println(parameterCount);



        Class<?>[] parameterTypes = constructor1.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
        }




    }
}
