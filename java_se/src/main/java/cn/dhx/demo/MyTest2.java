package cn.dhx.demo;

import cn.dhx.util.DateToolUtil;
import cn.dhx.util.JsonUtil;
import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/16 11:14
 */
@Slf4j
public class MyTest2 {

    public static void main(String[] args) {
        byte b=0x58;
        System.out.println((char) b);

        char c1 = 'X';

        byte b2 = (byte) c1;
        System.out.println(b2);
        System.out.println(intToHex(b2));



    }


    private static String intToHex(int n) {
        //StringBuffer s = new StringBuffer();
        StringBuilder sb = new StringBuilder(8);
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            sb = sb.append(b[n%16]);
            n = n/16;
        }
        a = sb.reverse().toString();
        return a;
    }
}
