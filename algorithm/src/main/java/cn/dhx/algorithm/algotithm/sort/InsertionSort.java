package cn.dhx.algorithm.algotithm.sort;

import java.util.Arrays;

//  插入法 时间复杂度为O(N^2)
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int t;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                } else {
                    break;
                }
            }
        }
    }
}
