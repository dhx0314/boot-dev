package cn.dhx.boot.entity;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;

import static cn.dhx.boot.entity.Demo.demoName;

@Data
public class User {



    private  Integer id;

    private String name;


    private  Integer age;

    @Expose
    protected String addr;


//    private Demo demo;


    @Override
    public String toString() {
        return new String("aa");
    }

    public void fun1() {
        System.out.println(demoName);
        System.out.println(age);
    }
}
