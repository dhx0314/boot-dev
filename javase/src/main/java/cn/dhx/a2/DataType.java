package cn.dhx.a2;

import org.junit.Test;

public class DataType {

    @Test
    public void fun1() {
        double d1 = 2.7;
        double d2 = 8.1 / 3;
        System.out.println(d2);//2.6999999999999997
        System.out.println(d1==d2);//false
        if (Math.abs(d1 - d2) < 0.000001) {
            System.out.println("======");
        }
    }
}
