package cn.dhx.boot.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Demo21 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            list.add(i);
        }
        System.out.println(list.toString());

        int limit =5;
        int index=1;
        int count = list.size() / limit;
        int a = list.size() % limit;
        if (a != 0) {
            count=count+1;
        }
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(i);//0 1 2 3
            int k=i*limit;
            ArrayList<Integer> list1 = new ArrayList<>();
            if (i == count-1) {
                for (int j = k; j < list.size(); j++) {
                    list1.add(k);
                    k++;
                }
            }else {
                for (int j = 0; j < limit; j++) {
                    list1.add(k);
                    k++;
                }
            }
            System.out.println(list1.toString());
        }

    }






}