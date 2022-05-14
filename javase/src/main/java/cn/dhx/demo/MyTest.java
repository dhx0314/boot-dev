package cn.dhx.demo;


import org.junit.Test;

public class MyTest {

    public static void main(String[] args) {

        int data[] = new int[3]; /*开辟了一个长度为3的数组*/
        data[0] = 10; // 第一个元素
        data[1] = 20; // 第二个元素
        data[2] = 30; // 第三个元素
        System.out.println(data.length);// 3


        int arr[] = {1,2,3};
        System.out.println(arr.length);	// 3

        int arr2[]=new int[]{4,5,6,7};
        System.out.println(arr2.length);// 4


        String str[] = {"aa", "bb", "cc"};
        char charArr[] = {'a', 'b'};

        //数据类型 对象数组[][] = new 数据类型[行个数][列个数];
        int a[][]=new int[2][3];
    }


}



