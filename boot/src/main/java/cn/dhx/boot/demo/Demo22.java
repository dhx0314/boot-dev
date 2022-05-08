package cn.dhx.boot.demo;

import java.util.ArrayList;
import java.util.List;

public class Demo22 {


    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
        int time = 0;
        int size = 0;
        int limitNum=5;
        if (list != null && list.size() > 0) {
            size = list.size();
            time = size / limitNum;
            if (size % limitNum == 0) {
                time = time - 1;
            }
        } else {
            return;
        }

        for (int i = 0; i <= time; i++) {
            List<Integer> sendDetailDto1;
            if (i == time) {
                sendDetailDto1 = list.subList(i * limitNum, size);
            } else {
                sendDetailDto1 = list.subList(i * limitNum, (i + 1) * limitNum);
            }
            System.out.println(sendDetailDto1);
        }
    }
}
