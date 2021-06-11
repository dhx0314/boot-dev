package cn.dhx.boot.demo;

import java.text.DecimalFormat;

public class Demo3 {

    public static void main(String[] args) {
//        float price=(float) 625.2135;
//        int a=1188;
//        int b=93;
//        double c;
//
//        c=(double)(Math.round(a*100/b)/100.0);//这样为保持2位
//        System.out.println(c);
        long l1=1000;
        long l2=876;
        double a1=(double) l2/l1;
        double a2= l2/l1;
        System.out.println(a2);
        System.out.println(a1);
//        System.out.println(a1);
//        double price = (double) l2/(double) l1;
//        int t= (int) (price*100);
//        System.out.println(t);
//        System.out.println((double)l2/l1);
//        System.out.println(price);
        DecimalFormat decimalFormat=new DecimalFormat(".00");//这里有几个0就保留几位，如果小数不足位,会以0补足.
        String price1=decimalFormat.format(a1);//format 返回的是字符串
        System.out.println(price1);
    }
}
