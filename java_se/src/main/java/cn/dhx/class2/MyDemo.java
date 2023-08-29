package cn.dhx.class2;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @Author daihongxin
 * @create 2023/5/29 15:03
 */
@Slf4j
public class MyDemo {
   public static  HashMap<String, Student> hashMap = new HashMap<>();
    public static void main(String[] args) {
        Student student = new Student();
        student.setClassName("3 class");
        student.setId(1234);
        hashMap.put("a", student);

        People people = hashMap.get("a");
        System.out.println("people  "+people);

        Student s2 = (Student) people;
        System.out.println(s2.getClassName());
        System.out.println(s2);
    }
}
