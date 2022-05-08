package cn.dhx.array;

import org.junit.Test;

public class MyArray {

    @Test
    public void fun1() {
        int[] arr1= new int [3];//声明 数组大小
        int[] arr2 = new int []{1001,1002,1003};// 声明+初始化
        int[] arr3 = {1,2,3,4,5};// 类型推断

        System.out.println(arr1.length);
    }
}
