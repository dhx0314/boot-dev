package cn.dhx.io.bio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MyFile {


    @Test
    public void fun1() throws IOException {
        File file = new File("a.txt");
        file.createNewFile();
    }

    @Test
    public void fun2() throws IOException {
        File file = new File("D:\\a2\\a","a2.txt");
        file.createNewFile();
    }

    @Test
    public void fun3() throws IOException {
        File file = new File("D:\\a2\\a");
        File file2 = new File(file,"a3.txt");
        file2.createNewFile();
    }

    @Test
    public void fun4() throws IOException {
        File file = new File("java_se/src/main/java/cn/dhx/io/bio/file/a.txt");
        //绝对路径
        System.out.println(file.getAbsolutePath());//D:\a2\a\a1.txt
        //父目录
        System.out.println(file.getParent());///D:\a2\a
        //文件大小 (字节)
        System.out.println(file.length());
        System.out.println(file.exists());//T
        System.out.println(file.isFile());//T
        System.out.println(file.isDirectory());//F
    }


    @Test
    public void fun5() throws IOException {
        File file = new File("D:\\a2\\a\\a1.txt");
        file.delete();
    }

    @Test
    public void fun6() throws IOException {
        File file = new File("D:\\a2\\aa");
        file.mkdirs();
    }
}
