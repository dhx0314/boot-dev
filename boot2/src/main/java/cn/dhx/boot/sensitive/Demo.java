package cn.dhx.boot.sensitive;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author daihongxin
 * @create 2023/10/11 16:05
 */
@Slf4j
public class Demo {

    @Test
    public void fun1() {
        String s = "1827077973";

//        String s1 = s.replaceAll("(\\d{3})\\d*(\\d{4})", "$1****$2");
//        String s1 = s.replaceAll("(\\d{3})\\d*(\\d{4})", "$1****$2");
        String s1 = s.replaceAll("(\\d{3})\\d*(\\d{4})", "$0_$1_$2");
        System.out.println(s1);
    }


    @Test
    public void fun2() {
        String DATE_STRING = "2017-04-252";
        String P_COMM = "(\\d{4})-((\\d{2})-(\\d{3}))";

        Pattern pattern = Pattern.compile(P_COMM);
        Matcher matcher = pattern.matcher(DATE_STRING);
        matcher.find();//必须要有这句
        System.out.printf("\nmatcher.group(0) value:%s", matcher.group(0));
        System.out.printf("\nmatcher.group(1) value:%s", matcher.group(1));
        System.out.printf("\nmatcher.group(2) value:%s", matcher.group(2));
        System.out.printf("\nmatcher.group(3) value:%s", matcher.group(3));
        System.out.printf("\nmatcher.group(4) value:%s", matcher.group(4));
    }
}
