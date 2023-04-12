package cn.dhx.io.streamio.characterstream;

import org.junit.Test;

import java.io.*;

public class MyOutputStreamWriter {


    //转换流
    @Test
    public void fun1() throws Exception {
        String path = "io\\gbk2.txt";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(path), "GBK");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("hello hi 世界");
        bufferedWriter.close();

    }
}
