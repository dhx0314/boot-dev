package cn.dhx.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    private Integer id;

    private String name;

    private Integer age;

    Object lock = new Object();

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
