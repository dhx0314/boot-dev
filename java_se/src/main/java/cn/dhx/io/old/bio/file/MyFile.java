package cn.dhx.io.old.bio.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MyFile {


    @Test
    public void newFile() throws IOException {
        File file = new File("a.txt");
        boolean newFile = file.createNewFile();

        File file1 = new File("D:");
        File file2 = new File(file, "a3.txt");

        File file3 = new File("D:", "a2.txt");
    }


    @Test
    public void list() {
        File file = new File(".");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
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
    public void delete() throws IOException {
        File file = new File("D:\\a2\\a\\a1.txt");
        file.delete();
    }

    @Test
    public void mkdirs() throws IOException {
        File file = new File("aa\\bb\\cc");
        file.mkdirs();
    }
}
