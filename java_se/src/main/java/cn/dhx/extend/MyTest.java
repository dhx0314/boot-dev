package cn.dhx.extend;

import cn.dhx.pojo.Stu;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/9/12 16:35
 */
@Slf4j
public class MyTest {


    @Test
    public void fun1() {
        Person.todo();
        Student.todo();

        Student student = new Student();
        student.todo();

        Person p = new Student();
        p.todo();
    }
}
