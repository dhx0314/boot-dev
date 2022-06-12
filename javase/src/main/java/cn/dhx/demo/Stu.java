package cn.dhx.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class Stu implements Serializable {

    private static final long serialVersionUID = -4392658638228508589L;


    private String id;

    private String name;

    public int add(int a){
        return 1;
    }

    public long add(int a,int b){
        return 1;
    }


}
