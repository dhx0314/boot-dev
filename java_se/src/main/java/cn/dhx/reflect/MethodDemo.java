package cn.dhx.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @Author daihongxin
 * @create 2023/7/6 10:59
 */
@Slf4j
public class MethodDemo {

    //
//    Class类中用于获取成员方法的方法
//    Method[] getMethods()：返回所有公共成员方法对象的数组，包括继承的
//    Method[] getDeclaredMethods()：返回所有成员方法对象的数组，不包括继承的
//    Method getMethod(String name, Class<?>... parameterTypes) ：返回单个公共成员方法对象
//    Method getDeclaredMethod(String name, Class<?>... parameterTypes)：返回单个成员方法对象
//
//
//            Method类中用于创建对象的方法
//    Object invoke(Object obj, Object... args)：运行方法
//    参数一：用obj对象调用该方法
//    参数二：调用方法的传递的参数（如果没有就不写）
//    返回值：方法的返回值（如果没有就不写）
//
//    获取方法的修饰符
//    获取方法的名字
//    获取方法的形参
//    获取方法的返回值
//    获取方法的抛出的异常
    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("cn.dhx.reflect.Student");

        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("------");
        //获取里面所有的方法对象(不能获取父类的，但是可以获取本类中私有的方法)
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        Method eat = aClass.getDeclaredMethod("eat", String.class);
        eat.setAccessible(true);
        int modifiers = eat.getModifiers();
        System.out.println(modifiers);

        //获取方法的名字
        String name = eat.getName();
        System.out.println(name);

        Class<?>[] parameterTypes = eat.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
        }

        Class<?>[] exceptionTypes = eat.getExceptionTypes();
        for (Class<?> exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }

        //方法运行
        /*Method类中用于创建对象的方法
        Object invoke(Object obj, Object... args)：运行方法
        参数一：用obj对象调用该方法
        参数二：调用方法的传递的参数（如果没有就不写）
        返回值：方法的返回值（如果没有就不写）*/

        Student student = new Student("lisi", 10, "aa");
        Object beef = eat.invoke(student, "beef");
    }
}
