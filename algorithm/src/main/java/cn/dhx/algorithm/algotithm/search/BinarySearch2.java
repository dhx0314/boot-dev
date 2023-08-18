package cn.dhx.algorithm.algotithm.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/5/10 23:49
 */
@Slf4j
public class BinarySearch2 {


    int[] array = {1, 2, 4, 4, 4, 5, 6, 7};

    @Test
    public void binarySearchLeftmost1Test() {

        //   i          m               j
        //   1  2   4   4   4   5   6   7
        //   0  1   2   3   4   5   6   7

        //   i  m   j
        //   1  2   4   4   4   5   6   7
        //   0  1   2   3   4   5   6   7


        //      m
        //      i   j
        //   1  2   4   4   4   5   6   7
        //   0  1   2   3   4   5   6   7


        //          m
        //          ij
        //   1  2   4   4   4   5   6   7
        //   0  1   2   3   4   5   6   7
        System.out.println(binarySearchLeftmost1(array, 4));
        System.out.println(binarySearchLeftmost(array, 4));
    }

    public static int binarySearchLeftmost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public static int binarySearchLeftmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                candidate = m; // 记录候选位置
                j = m - 1;     // 继续向左
            }
        }
        return candidate;
    }

    @Test
    public void binarySearchRightmost1Test() {

        //   i          m               j
        //   1  2   4   4   4   5   6   7
        //   0  1   2   3   4   5   6   7


        //                  i           j
        //   1  2   4   4   4   5   6   7
        //   0  1   2   3   4   5   6   7


        System.out.println(binarySearchRightmost1(array, 4));
        System.out.println(binarySearchRightmost(array, 4));
    }


    public static int binarySearchRightmost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }

    public static int binarySearchRightmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                candidate = m; // 记录候选位置
                i = m + 1;       // 继续向右
            }
        }
        return candidate;
    }



}
