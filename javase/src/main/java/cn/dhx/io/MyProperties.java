package cn.dhx.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

public class MyProperties {


    @Test
    public void fun1() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("e:\\a\\mysql.Properties"));
        // 输出到控制台
        properties.list(System.out);
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println(user);
        System.out.println(pwd);
    }


    @Test
    public void fun2() throws Exception {
        Properties properties = new Properties();
        // 如果该文件有key,就是修改
        properties.setProperty("key","value");
        properties.setProperty("charset","utf-8");
        //中文保存的是unicode码
        properties.setProperty("test","测试");
        properties.store(new FileOutputStream("e:\\a\\mysql2.Properties"),null);
    }


    @Test
    public void fun3() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("e:\\a\\mysql.Properties"));
        String pwd = properties.getProperty("pwd");
        System.out.println(pwd);
        properties.setProperty("key","value");
        properties.store(new FileOutputStream("e:\\a\\mysql.Properties"),null);
    }
}
