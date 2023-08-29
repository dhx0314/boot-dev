package cn.dhx.reflect;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Author daihongxin
 * @create 2023/7/6 10:45
 */
@Slf4j
public class FieldsDemo {


    //       Class类中用于获取成员变量的方法
    //            Field[] getFields()：                返回所有公共成员变量对象的数组
    //            Field[] getDeclaredFields()：        返回所有成员变量对象的数组
    //            Field getField(String name)：        返回单个公共成员变量对象
    //            Field getDeclaredField(String name)：返回单个成员变量对象
    //
    //       Field类中用于创建对象的方法
    //            void set(Object obj, Object value)：赋值
    //            Object get(Object obj)              获取值
    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("cn.dhx.reflect.Student");

        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("--------------------");

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        System.out.println("--------------");

        Field gender = aClass.getField("gender");
        System.out.println(gender);

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name);


        Field age = aClass.getDeclaredField("age");
        age.setAccessible(true);


        int modifiers = name.getModifiers();
        System.out.println("modifiers: " + modifiers);
        String name1 = name.getName();
        System.out.println("name1: " + name1);

        Class<?> type = name.getType();
        System.out.println("type:" + type);

        Student student = new Student("张三", 18, "aa");
        String nameStr = (String) name.get(student);
        System.out.println(nameStr);


        System.out.println(student);
        name.set(student, "lisi");
        System.out.println(student);

    }


    @Test
    public void fun2() throws Exception, IllegalAccessException {
        Class<?> studentClass = Class.forName("cn.dhx.reflect.Student");
//        Class<Student> studentClass = Student.class;
        Field id = studentClass.getField("id");
        Object id1 = id.get(Student.class);
        System.out.println(id1);

        Object id2 = id.get("id");
        System.out.println(id2);


    }



}
