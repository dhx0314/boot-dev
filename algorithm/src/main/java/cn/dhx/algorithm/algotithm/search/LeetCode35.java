package cn.dhx.algorithm.algotithm.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/8/18 12:12
 */
@Slf4j
public class LeetCode35 {

    //给定一个排序数组和一个目标值
    //
    //* 在数组中找到目标值，并返回其索引
    //* 如果目标值不存在于数组中，返回它将会被按顺序插入的位置
    //
    //例如
    //
    //```
    //输入: nums = [1,3,5,6], target = 5
    //输出: 2
    //
    //输入: nums = [1,3,5,6], target = 2
    //输出: 1
    //
    //输入: nums = [1,3,5,6], target = 7
    //输出: 4
    //```


    // i   m    j
    // 1 3 5 6
    // 0 1 2 3 4

    // i m j
    // 1 3 5 6
    // 0 1 2 3 4


    //
    // i j
    // 1 3 5 6
    // 0 1 2 3 4


    @Test
    public static void main(String[] args) {
        int[] array = {1,3,5,6};
        System.out.println(searchInsert(array, 7));
        System.out.println(searchInsert(array, 2));


    }

    public static int searchInsert(int arr[], int target) {

        int i = 0;
        int j = arr.length;
        int m = 0;
        while (i < j) {
            m = (i + j) >>> 1;
            if (arr[m] < target) {
                i = m + 1;
            } else if (arr[m] > target) {
                j = m;
            } else {
                return m;
            }

        }
        return i ;
    }


    public int searchInsert2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while(i <= j) {
            int m = (i + j) >>> 1;
            if(target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
