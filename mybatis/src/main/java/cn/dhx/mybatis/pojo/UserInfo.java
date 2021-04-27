package cn.dhx.mybatis.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo extends Thread{

    private String Username;

    private Integer age;

    private volatile Boolean start=false;

    public UserInfo(String name, Integer age) {
        this.Username = name;
        this.age = age;
    }

    public void run(){
        if (!start) {
            start=true;
            System.out.println("--------------------------------");
        }
    }



}
