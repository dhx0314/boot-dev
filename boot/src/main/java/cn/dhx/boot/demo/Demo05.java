package cn.dhx.boot.demo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo05 {

    public static void main(String[] args) {
//        String mpsRanges="MPS-1722";
//        String[] split = mpsRanges.split(";");
//        ArrayList<String> mpsList = new ArrayList<>(Arrays.asList(split));
//        System.out.println(mpsList.size());
//        System.out.println(mpsList.toString());
        long length=2000;
        long lengthRecord=100;
        double recordPer = (double) length / lengthRecord;
        //这里有几个0就保留几位，如果小数不足位,会以0补足.
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        String format = decimalFormat.format(recordPer);
        System.out.println(format);
//        double per=Double.parseDouble(format);
//        int recordPer1 = (int)(per * 100);

        int recordPer1 = (int) (Double.parseDouble(decimalFormat.format(recordPer)) * 100);
        System.out.println(recordPer1);
    }
}
