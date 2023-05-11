package cn.dhx.algorithm.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/5/10 23:49
 */
@Slf4j
public class BinarySearch {


    @Test
    public void BinarySearchBasicTest() {
        // 查3

        // i     m        j
        // 1 3 5 6 11 18 22
        // 0 1 2 3 4  5   6

        // i m j
        // 1 3 5
        // 0 1 2
        int[] array = {1, 3, 5, 6, 11, 18, 22};

        System.out.println(BinarySearchBasic(array, 1));
        System.out.println(BinarySearchBasic(array, 3));
        System.out.println(BinarySearchBasic(array, 5));
        System.out.println(BinarySearchBasic(array, 6));
        System.out.println(BinarySearchBasic(array, 22));
        System.out.println(BinarySearchBasic(array, 23));


    }

    public int BinarySearchBasic(int[] arr, int target) {

        // 左闭 右闭边界
        int i = 0;
        int j = arr.length - 1; //j是查找目标
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else if (target > arr[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }

        return -1;

    }


    @Test
    public void BinarySearchProTest() {
        // 查3

        // i     m           j
        // 1 3 5 6 11 18 22
        // 0 1 2 3 4  5   6  7

        // i   m j
        // 1 3 5 6
        // 0 1 2 3

        // i m j
        // 1 3 5
        // 0 1 2
        int[] array = {1, 3, 5, 6, 11, 18, 22};

        System.out.println(BinarySearchPro(array, 1));
        System.out.println(BinarySearchPro(array, 3));
        System.out.println(BinarySearchPro(array, 5));
        System.out.println(BinarySearchPro(array, 6));
        System.out.println(BinarySearchPro(array, 22));
        System.out.println(BinarySearchPro(array, 23));


    }

    public int BinarySearchPro(int[] arr, int target) {

        // 左闭 右开边界
        int i = 0;
        int j = arr.length; //j不是查找目标,只作为边界
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;
            } else if (target > arr[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }

        return -1;

    }

}
