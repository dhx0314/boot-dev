package cn.dhx.algorithm.dhxdemo;


import lombok.Data;

import java.util.ArrayList;

@Data
public class MyArray {


    private Integer i;
    private ArrayList<MyArray> myArrays;
//    private int[] arr;

    public MyArray() {
    }

    public MyArray(int i) {
        this.i = i;
    }

    public MyArray(ArrayList<MyArray> myArrays) {
        this.myArrays = myArrays;
    }

    public Integer getI() {
        return i;
    }


    //
//    public MyArray(int[] arr) {
//        this.arr = arr;
//    }

    @Override
    public String toString() {
        return "MyArray{" +
                "i=" + i +
                ", myArrays=" + myArrays +
                '}';
    }
}
