package cn.dhx.algorithm.algotithm.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/5/10 23:49
 */
@Slf4j
public class BinarySearch {


    //假设一个数组为{0，1，2，3，4，5，6，7，8，9}，
    //
    //①左闭右闭 假设我们想要索引到6这个数字，缩小范围到某一时刻left和right都指向6，
    //那么此时的索引区间为[left,right]（也就是[6,6]），也就是说6这个数字还没有找过，因此当left=right时，
    //还要继续找，使mid=(left+right)/2 = 6，再与索引值进行比较才能得到6这个值，
    //所以while里的条件要写成(left <= right)。如果写成(left<right)，那么当left和right都指向6的时候，循环结束，6这个数字就无法被索引到
    //
    //假设一个数组为{0，1，2，3，4，5，7，8，9}，
    //
    //②左闭右开 假设当left和right都指向数字7，我们想要索引到数字6，那么索引区间为[left,right)
    //（也就是[6,6)）此时索引区间已经没有数字可以进行查找了，如果将条件写为(left<=right)
    //那么它还会继续索引使mid=(left+right)/2还是指向数字7，索引值比mid指向的值要小，因此right=mid，
    //则又陷入死循环，所以while里面的条件要写成(left < right)

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
            log.info("i {} j{} m{}",i,j,m);
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


    @Test
    public void binarySearchBalanceTest() {
        // i     m        j
        // 1 3 5 6 11 18 22
        // 0 1 2 3 4  5   6

        // i m j
        // 1 3 5
        // 0 1 2

        // i m j
        // 1 3 5
        // 0 1 2


        int[] array = {1, 3, 5, 6, 11, 18, 22};

        System.out.println(binarySearchBalance(array, 1));
        System.out.println(binarySearchBalance(array, 3));
        System.out.println(binarySearchBalance(array, 5));
        System.out.println(binarySearchBalance(array, 6));
        System.out.println(binarySearchBalance(array, 22));
        System.out.println(binarySearchBalance(array, 23));

    }

    public static int binarySearchBalance(int[] a, int target) {

        int i = 0, j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        return (a[i] == target) ? i : -1;
    }

}
