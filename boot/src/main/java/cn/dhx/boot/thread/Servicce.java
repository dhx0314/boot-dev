package cn.dhx.boot.thread;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Servicce implements Runnable{


    private String name;
    private String age;
    ArrayList<String> arrayList=new ArrayList<>();
    public void add() {
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        System.out.println(arrayList.size());
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(Thread.currentThread().getName());
    }

    public Servicce() {
    }

    public Servicce(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void run() {
        add();
    }
}
