package cn.dhx.bootdemo.entity;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class User {



    private  Integer id;

    private String name;


    private  Integer age;

    @Expose
    protected String addr;


//    private Demo demo;


}
