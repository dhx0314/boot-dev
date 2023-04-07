package cn.dhx.io.streamio.characterstream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MyInputStreamReader {

    @Test
    public void fun() throws Exception {
        // gbk编码的文件
        String path = "e:\\a\\gbk.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path), "GBK");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();
    }
}
