package cn.dhx.interface2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/5/15 15:26
 *
 * 接口默认方法重写,实现类可以重写这个方法，
 * 接口可以有静态方法
 */
@Slf4j
public class defaultMethodDemo {


    @Test
    public void fun1() {
        System.out.println(new Stu().getName());
        System.out.println(new Worker().getName());
    }
}

interface People {

    default public String getName() {
        return "people";
    }
    static public String getPhone() {
        return "1234";
    }
}

class Stu implements People{
    public String getName() {
        return "stu";
    }
}

class Worker implements People{

}

