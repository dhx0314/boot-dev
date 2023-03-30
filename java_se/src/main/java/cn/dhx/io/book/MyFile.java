package cn.dhx.io.book;

import org.junit.Test;

import java.io.File;

/**
 * @Author daihongxin
 * @create 2023/3/30 21:07
 */

public class MyFile {

    @Test
    public void file1() {
        File file = new File(".");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
