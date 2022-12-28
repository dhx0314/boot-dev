package cn.dhx.bootdemo.java.basic;

import org.junit.Test;

import java.math.BigDecimal;

public class Demo03 {
    public static void main(String[] args) {

        double d1=0.34;
        double d2=3;
        double d3=d1*d2;
        System.out.println(d3);
        BigDecimal A = new BigDecimal("3.90");
        BigDecimal B = new BigDecimal("2");
        BigDecimal add = A.add(B);
        System.out.println(add);
        BigDecimal subtract = A.subtract(B);
        System.out.println(subtract);
        BigDecimal multiply = A.multiply(B);
        System.out.println(multiply);
        BigDecimal divide = A.divide(B,BigDecimal.ROUND_CEILING);
        System.out.println(divide);
    }


    @Test
    public void fun1() {
        double d=0.33;
        BigDecimal bigDecimal = new BigDecimal(d);
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(d));
        System.out.println(bigDecimal1);
        BigDecimal bigDecimal2 = new BigDecimal("0.33");
        System.out.println(bigDecimal2);


    }
}
