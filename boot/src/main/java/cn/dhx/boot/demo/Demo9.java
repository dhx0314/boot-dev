package cn.dhx.boot.demo;

import java.util.ArrayList;

public class Demo9 {

    public static void main(String[] args) {
//        String s=null;
//        System.out.println("".equals(s));

//        String deviceId = entry.getKey();
//        boolean matches = deviceId.matches("\263[0,2,6,7]\\d*");

        ArrayList<String> strings = new ArrayList<>();
        strings.add("2630156");
        strings.add("2631156");
        strings.add("2632156");
        strings.add("2633156");
        strings.add("2634156");
        strings.add("2635156");
        for (String string : strings) {
            boolean matches = string.matches("263[0,2,6,7]\\d*");
            System.out.println(matches);
        }
    }
}
