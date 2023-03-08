package cn.dhx.io.bio.readerandwriter;

import org.junit.Test;

import java.io.*;

public class MyBufferedWriter {

    @Test
    public void fun1() throws Exception {
        String path = "e:\\a\\Stu.text";
        //追加内容
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        String lineStr = "hello,处理流测试";
        bufferedWriter.write(lineStr);
        //插入和系统相关的换行符
        bufferedWriter.newLine();
        bufferedWriter.write(lineStr);
        bufferedWriter.newLine();
        // 关闭外层处理流即可
        bufferedWriter.close();
    }


    @Test
    public void fun2() throws Exception {
        String path = "e:\\a\\Stu.java";
        String path2 = "e:\\a\\Stu2.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path2, true));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedWriter.close();
    }
}
