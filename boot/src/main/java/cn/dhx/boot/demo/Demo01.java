package cn.dhx.boot.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Demo01 {

    private  static Stu22 stu22;

    @Autowired
    public void setStu22(Stu22 stu) {
        stu22 = stu;
    }

    public static void fun1() {
        log.info("---------static");
        stu22.fun1();
    }



}
