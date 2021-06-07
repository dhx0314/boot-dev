package cn.dhx.boot.thread2;


import org.springframework.stereotype.Service;

@Service
public class ServiceDemo2 {


    public static void fun1(Stu stu,String name) {
        stu.getList().add(name);
        stu.getList().add("name2");
    }
}
