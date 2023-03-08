package cn.dhx.io.bio.readerandwriter;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class MyBufferedReader {

    @Test
    public void fun1() throws Exception {
        String path = "e:\\a\\Stu.java";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        //readLine 按行读取
        // 返回null时,表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        // 关闭外层处理流即可
        bufferedReader.close();
    }
}
