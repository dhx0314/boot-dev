package cn.dhx.demo;

import cn.dhx.util.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;

public class MyIo {


    @Test
    public void fun1() throws Exception {

        String path = "d:\\a\\0621\\rcs-info.20220621-0.log";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            boolean contains = line.contains("get MPS-98 recfile info");
            if (contains) {
                System.out.println(line);
                int start = line.indexOf("{");
                int end = line.indexOf("}");
                String substring = line.substring(start, end + 1);
                System.out.println(substring);

                RecFile recFile = JsonUtil.toObject(substring, RecFile.class);
                System.out.println(recFile.toString());

            }
        }
        bufferedReader.close();

        System.exit(0);
    }
}
