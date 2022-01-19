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


}
