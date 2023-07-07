package cn.dhx.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/7/7 10:40
 */
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {

    private String name;
    private double salary;


    public void teach(){
        System.out.println("老师在教书！");
    }

}
