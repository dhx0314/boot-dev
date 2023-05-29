package cn.dhx.class2;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/5/29 15:03
 */
@Slf4j
@Data
@ToString(callSuper = true)
public class Student extends People{

    private String className;
}
