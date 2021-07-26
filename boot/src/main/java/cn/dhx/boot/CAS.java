package cn.dhx.boot;

import lombok.val;

import java.util.ArrayList;

public class CAS {



    public static void main(String[] args) {

        Rec rec = new Rec();
        rec.add();
        ArrayList<String> arrayList = rec.getArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        System.out.println(arrayList.size());
        arrayList.remove("3");
        Rec rec1 = new Rec();
        val size = rec.getArrayList().size();
        System.out.println(size);
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                synchronized (arrayList) {
//                    for (int j = 0; j < 5; j++) {
//                        arrayList.add("k" + j);
//                        System.out.println(Thread.currentThread().getName() + "add");
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        arrayList.remove("k"+1);
//                    }
//                }
//
//            }).start();
//        }
    }


    public void fun1() {
//
    }
}

class Rec {

    ArrayList<String> arrayList=new ArrayList<>();

    public void add() {
        arrayList.add("start");
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }
}




