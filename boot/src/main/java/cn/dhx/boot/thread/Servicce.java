package cn.dhx.boot.thread;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Servicce {


     ArrayList<String> arrayList=new ArrayList<>();


    public void add() {
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        System.out.println(arrayList.size());
    }
}
