package cn.dhx.io;

import org.junit.Test;

import java.io.FileWriter;

public class MyFileWriter {


    @Test
    public void fun1() throws Exception{
        String filePath = "D:\\a2\\a\\stream.txt";
        FileWriter fileWriter = new FileWriter(filePath, true);
        fileWriter.write("H");
        fileWriter.write("abcd");

        String s="你好";
        char[] chars = s.toCharArray();
        fileWriter.write(chars);

        String s2="qwer";
        char[] chars1 = s2.toCharArray();
        fileWriter.write(chars1,1,3);

        String s3="你好世界";
        fileWriter.write(s3,2,2);

        fileWriter.flush();
        fileWriter.close();// flush +关闭
//        Habcd你好wer世界

    }
}
