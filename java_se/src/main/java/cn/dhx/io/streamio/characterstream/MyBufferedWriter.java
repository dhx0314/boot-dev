package cn.dhx.io.streamio.characterstream;

import org.junit.Test;

import java.io.*;

public class MyBufferedWriter {

    @Test
    public void writer() throws Exception {
        String path = "io\\StuBufferedWriter.text";
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
    public void readAndWrite() throws Exception {
        String readPath = "io\\Stu.java";
        String writePath = "io\\BufferedWriter.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(readPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writePath, true));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedWriter.close();
    }
}
