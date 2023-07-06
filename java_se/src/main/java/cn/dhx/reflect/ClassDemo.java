package cn.dhx.reflect;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/7/6 10:34
 */
@Slf4j
public class ClassDemo {

    public static void main(String[] args) {
        try {
            Class<?> clazz1 = Class.forName("cn.dhx.reflect.Student");
            Class<Student> clazz2 = Student.class;
            Student student = new Student();
            Class<? extends Student> clazz3 = student.getClass();
            System.out.println(clazz1 == clazz2);
            System.out.println(clazz2 == clazz3);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
