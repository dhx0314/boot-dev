package cn.dhx.jvm.memory.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/6/5 21:55
 */
@Slf4j
public class StringTableDemo {


    @Test
    public void fun1() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";  // javac编译期间的优化,结果已经在编译器确定为ab
        String s4 = s1 + s2;    //  底层  String s4 = new StringBuilder().append(s1).append(s2).toString();
        String s5 = "ab";
        String s6 = s4.intern();    //主动将串池中还没有的字符串对象放入串池中,
        // 1.8 将这个字符串对象尝试放入串池，如果有则并不会放入，如果没有则放入串池。会把串池中的对象返回


        System.out.println(s3 == s4);   //false
        System.out.println(s3 == s5);   //true
        System.out.println(s3 == s6);   //true
    }

    @Test
    public void fun2() {
        String x2 = new String("a") + new String("b");
        String intern = x2.intern();
        String x = "ab";
        System.out.println(intern == x);   //true
        System.out.println(x2 == x);       //true
    }

    @Test
    public void fun3() {
        String x = "ab";
        String x2 = new String("a") + new String("b");
        String intern = x2.intern();
        System.out.println(intern == x);   //true
        System.out.println(x2 == x);       //false
    }

    @Test
    public void fun4() {
        String x2 = new String("c") + new String("d");
        String x = "cd";
        x2.intern();
        System.out.println(x == x2);    //false
    }

    @Test
    public void fun5() {
        String x2 = new String("c") + new String("d");
        x2.intern();
        String x = "cd";
        System.out.println(x == x2);    //true
    }
}
