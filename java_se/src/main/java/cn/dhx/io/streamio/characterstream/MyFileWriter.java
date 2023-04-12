package cn.dhx.io.streamio.characterstream;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;

public class MyFileWriter {


    @Test
    public void write() throws Exception{
        String filePath = "io\\characterStream.txt";
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


    @Test
    public void readAndWrite() throws Exception{
        String readPath = "io\\characterStreamRead.txt";
        String writePath = "io\\characterStreamWrite.txt";
        FileReader fileReader = new FileReader(readPath);
        FileWriter fileWriter = new FileWriter(writePath);
        int readLen=0;
        char[] chars=new char[8];
        // 循环读取,返回的是实际读取的字符数
        // 返回-1,说明到文件结束
        while ((readLen = fileReader.read(chars)) != -1) {
            fileWriter.write(chars, 0, readLen);
            System.out.println(new String(chars, 0, readLen));
        }
        fileReader.close();
        fileWriter.close();

//        fileWriter.write(chars);
//        hello world!
//                你好世界d!
//                你好
    }
}
