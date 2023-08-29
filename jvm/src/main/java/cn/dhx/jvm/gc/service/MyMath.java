package cn.dhx.jvm.gc.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/8/23 9:47
 */
@Slf4j
public class MyMath {

    public static final int initData = 666;


    public int compute() { //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }
}
