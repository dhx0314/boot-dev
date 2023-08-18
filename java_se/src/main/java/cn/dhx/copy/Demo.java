package cn.dhx.copy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author daihongxin
 * @create 2023/8/14 15:12
 */
@Slf4j
public class Demo {



    //浅拷贝 是指在对一个对象进行拷贝时，只拷贝对象本身和其中的基本数据类型，而不拷贝对象内部的引用类型。因此，
    //      在浅拷贝的对象中，引用类型的变量指向的依旧是原始对象中的引用。
    //深拷贝 是指在对一个对象进行拷贝时，不仅拷贝对象本身和其中的基本数据类型，同时也拷贝对象内部的引用类型
    //      ,不再指向原有对象地址
    @Test
    public void fun1() throws CloneNotSupportedException {
        Phone iphone = new Phone("iphone");
        User user = new User("zhangsan", 20, iphone);
        log.info("user {} ", user);
        User cloneUser = (User) user.clone();
        cloneUser.setName("lsi");
        cloneUser.setAge(30);
        log.info("user {} ", user);
        log.info("cloneUser {} ", cloneUser);

        System.out.println("----------------------");
        Phone phone = cloneUser.getPhone();
        phone.setName("mi");
        log.info("user {} ", user);
        log.info("cloneUser {} ", cloneUser);

    }


    @Test
    public void fun2() throws Exception {
        Phone iphone = new Phone("iphone");
        User user = new User("zhangsan", 20, iphone);
        log.info("user {} ", user);
        User cloneUser =  user.copyUser3();
        cloneUser.setName("lsi");
        cloneUser.setAge(30);
        log.info("user {} ", user);
        log.info("cloneUser {} ", cloneUser);

        System.out.println("----------------------");
        Phone phone = user.getPhone();
        phone.setName("mi");
        log.info("user {} ", user);
        log.info("cloneUser {} ", cloneUser);

    }

    @Test
    public void fun3() throws Exception {
        Phone iphone = new Phone("iphone");
        User user = new User("zhangsan", 20, iphone);
        log.info("user {} ", user);
        User cloneUser = user.copyUser4();
        cloneUser.setName("lsi");
        cloneUser.setAge(30);
        log.info("user {} ", user);
        log.info("cloneUser {} ", cloneUser);

        System.out.println("----------------------");
        Phone phone = cloneUser.getPhone();
        phone.setName("mi");
        log.info("user {} ", user);
        log.info("cloneUser {} ", cloneUser);

    }
}
