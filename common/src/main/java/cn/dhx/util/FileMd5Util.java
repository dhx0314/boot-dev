package cn.dhx.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author daihongxin
 * @create 2023/3/22 18:44
 */
public class FileMd5Util {


    @Test
    public void fun1() {
        String str = "a.txt";
        try {
            String s = DigestUtils.md5Hex(new FileInputStream(str));
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
