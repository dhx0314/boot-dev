package cn.dhx.jvm.heap;

import java.util.ArrayList;


// java.lang.OutOfMemoryError: Java heap space

//   -Xmx8m
public class JavaHeapSpace {

    public static void main(String[] args) {
        int i = 0;
        try {
            ArrayList<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
