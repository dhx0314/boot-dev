package cn.dhx.io.bio.readerandwriter;

import org.junit.Test;

import java.io.*;

public class MyOutputStreamWriter {


    @Test
    public void fun1() throws Exception {
        String path = "e:\\a\\gbk2.txt";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(path), "GBK");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("hello hi 世界");
        bufferedWriter.close();

    }
}
