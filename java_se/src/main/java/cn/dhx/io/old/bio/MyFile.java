package cn.dhx.io.old.bio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MyFile {


    @Test
    public void fun1() throws IOException {
        File file = new File("a.txt");
        boolean newFile = file.createNewFile();
        System.out.println(newFile);
    }

    @Test
    public void fun2() throws IOException {
        File file = new File("D:\\a2\\a", "a2.txt");
        boolean newFile = file.createNewFile();
        System.out.println(newFile);
    }

    @Test
    public void fun3() throws IOException {
        File file = new File("D:\\a2\\a");
        File file2 = new File(file, "a3.txt");
        boolean newFile = file2.createNewFile();
        System.out.println(newFile);
    }

    @Test
    public void fun4() throws IOException {
        File file = new File("a.txt");
        //绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(file.getAbsolutePath());
        //父目录
        System.out.println(file.getParent());
        //文件大小 (字节)
        System.out.println(file.length());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());


        File file2 = new File(absolutePath);
        //绝对路径
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getParent());

        //C:\D\gitee\boot-dev\java_se\a.txt
        //null
        //5
        //true
        //true
        //false
    }


    @Test
    public void fun5() throws IOException {
        File file = new File("D:\\a2\\a\\a1.txt");
        file.delete();
    }

    @Test
    public void fun6() throws IOException {
        File file = new File("aa\\bb\\cc");
        file.mkdirs();
    }
}
