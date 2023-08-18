package cn.dhx.algorithm.algotithm.sort;

import java.util.Arrays;

// 冒泡排序的时间复杂度为O(N^2)
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public  static  void sort(int[] arr) {
        int t;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}
