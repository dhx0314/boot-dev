package cn.dhx.reflect;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Author daihongxin
 * @create 2023/7/6 10:35
 */
@Slf4j
@ToString
public class Student {

    public static long id = 100;

    private String name;
    private int age;
    public String gender;

    public Student() {
    }

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public Student(String name) {
        this.name = name;
    }

    protected Student(int age) {
        this.age = age;
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    private String eat(String something) throws IOException, NullPointerException, ClassCastException {
        System.out.println("在吃" + something);
        return "奥利给";
    }

    private void eat(String something, int a) {
        System.out.println("在吃" + something);
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }


}
