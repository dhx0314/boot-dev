package cn.dhx.boot.entity;

import lombok.Data;

import java.util.List;

import static cn.dhx.boot.entity.Demo.demoName;

@Data
public class User {

    private  Integer id;

    private String name;

    private  Integer age;

    private Demo demo;


    public void fun1() {
        System.out.println(demoName);
        System.out.println(age);
    }
}
