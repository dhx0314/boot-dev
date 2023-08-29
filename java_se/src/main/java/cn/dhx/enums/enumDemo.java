package cn.dhx.enums;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/8/21 17:28
 */
@Slf4j
public class enumDemo {

    public static void main(String[] args) {

        System.out.println("in".equals(CallDirectEnum.IN.getType()));

        CallDirectEnum in = CallDirectEnum.valueOf("IN");
        System.out.println(in==CallDirectEnum.IN);
    }



}
