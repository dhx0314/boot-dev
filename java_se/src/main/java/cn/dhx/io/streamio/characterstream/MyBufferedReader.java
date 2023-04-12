package cn.dhx.io.streamio.characterstream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class MyBufferedReader {

    @Test
    public void read() throws Exception {
        String path = "io\\Stu.java";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        //readLine 按行读取
        // 返回null时,表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        // 关闭外层处理流即可

        //关闭流的顺序和打开流的顺序相反。只要关闭最外层流即可，关闭最外层流也会相应关闭内层节点流
        bufferedReader.close();
    }
}
