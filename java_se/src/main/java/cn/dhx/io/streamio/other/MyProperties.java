package cn.dhx.io.streamio.other;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

public class MyProperties {


    @Test
    public void read() throws Exception {
        Properties properties = new Properties();
        String path = "io\\mysql.Properties";
        properties.load(new FileReader(path));
//        properties.load(new FileInputStream(path));
        // 输出到控制台
        properties.list(System.out);
        String key = properties.getProperty("key");
        System.out.println(key);
    }


    @Test
    public void read2() throws Exception {
        Properties properties = new Properties();
        String path = "io\\mysql.Properties";
        properties.load(new FileInputStream(path));
        // 输出到控制台
        properties.list(System.out);
        String key = properties.getProperty("key");
        System.out.println(key);
    }


    @Test
    public void writeProperties() throws Exception {
        Properties properties = new Properties();
        // 如果该文件有key,就是修改
        properties.setProperty("key", "value");
        properties.setProperty("charset", "utf-8");
        //中文保存的是unicode码
        properties.setProperty("test", "测试");
        String path = "io\\mysql.Properties";
        properties.store(new FileOutputStream(path), null);
    }
}
