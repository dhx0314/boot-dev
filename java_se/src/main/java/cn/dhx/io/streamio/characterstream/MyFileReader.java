package cn.dhx.io.streamio.characterstream;

import org.junit.Test;

import java.io.FileReader;

public class MyFileReader {

    @Test
    public void readOne() throws Exception{
        String filePath = "io\\characterStream.txt";
        FileReader fileReader = new FileReader(filePath);
        int data=0;
        //Reads a single character.
        while ((data = fileReader.read()) != -1) {
            System.out.println((char) data);
        }
        fileReader.close();

    }


    @Test
    public void read() throws Exception{
        String filePath = "io\\characterStream.txt";
        FileReader fileReader = new FileReader(filePath);
        int readLen=0;
        char[] chars=new char[8];
        // 循环读取,返回的是实际读取的字符数
        // 返回-1,说明到文件结束
        while ((readLen = fileReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, readLen));
        }
        fileReader.close();
    }
}
