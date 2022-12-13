package cn.dhx.algorithm.dhxdemo;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;

@Slf4j
public class Test1 {


    // [1, [89, 27], 3, [9, [12, 52, 27], 10], 37, 98]
    @Test
    public void fun2() {

        ArrayList<MyArray> myArraysAll = new ArrayList<>();


        MyArray myArray1 = new MyArray();
        myArray1.setI(1);

        MyArray myArray2 = new MyArray();
        ArrayList<MyArray> myArrays = new ArrayList<>();
        myArrays.add(new MyArray(89));
        myArrays.add(new MyArray(27));
        myArray2.setMyArrays(myArrays);

        MyArray myArray3 = new MyArray();
        myArray3.setI(3);

        MyArray myArray4 = new MyArray();

        ArrayList<MyArray> myArrays1 = new ArrayList<>();
        myArrays1.add(new MyArray(9));

        ArrayList<MyArray> myArrays2 = new ArrayList<>();
        myArrays2.add(new MyArray(12));
        myArrays2.add(new MyArray(52));
        myArrays2.add(new MyArray(27));

        myArrays1.add(new MyArray(myArrays2));
        myArrays1.add(new MyArray(10));

        myArray4.setMyArrays(myArrays1);

        MyArray myArray5 = new MyArray();
        myArray5.setI(37);
        MyArray myArray6 = new MyArray();
        myArray6.setI(98);

        myArraysAll.add(myArray1);
        myArraysAll.add(myArray2);
        myArraysAll.add(myArray3);
        myArraysAll.add(myArray4);
        myArraysAll.add(myArray5);
        myArraysAll.add(myArray6);
        String s = myArraysAll.toString();
        System.out.println(s);

        int sum = 0;
        for (MyArray myArray : myArrays2) {
            Integer i = myArray.getI();
            if (null != i) {
                sum = sum + i;
            }
            ArrayList<MyArray> myArrays3 = myArray.getMyArrays();
            if (myArrays3 != null) {
                for (MyArray array : myArrays3) {
                    Integer anInt = getInt(array);
                    sum =sum +anInt;
                }
            }
        }

        System.out.println(sum);

    }


    public static Integer getInt(MyArray myArray) {
        int sum=0;
        Integer i = myArray.getI();
        if (null != i) {
            sum=sum+i;
        }
        ArrayList<MyArray> myArrays = myArray.getMyArrays();
        if (myArrays != null) {
            for (MyArray array : myArrays) {
                Integer anInt = getInt(myArray);
                sum = sum + anInt;
            }
        }
        return sum;
    }




    @Test
    public void fun1() {
        System.out.println(digui(100));
        System.out.println(digui2(1));
    }


    public static int digui(int n) {
        if (n == 1) {
            return 1;
        }
        return n + digui(n - 1);
    }

    public static int digui2(int n) {
        if (n == 100) {
            return 100;
        }
        return n + digui2(n + 1);
    }
}
