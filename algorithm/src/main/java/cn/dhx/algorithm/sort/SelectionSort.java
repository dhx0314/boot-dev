package cn.dhx.algorithm.sort;

import java.util.Arrays;

// 选择法  时间复杂度为O(N^2)
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int minIndex;
        int t;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                t = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = t;
            }

        }
    }
}
