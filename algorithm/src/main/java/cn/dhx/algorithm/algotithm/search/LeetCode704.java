package cn.dhx.algorithm.algotithm.search;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/8/18 12:12
 */
@Slf4j
public class LeetCode704 {

    //输入: nums = [-1,0,3,5,9,12], target = 9
    //输出: 4
    //解释: 9 出现在 nums 中并且下标为 4
    //
    //输入: nums = [-1,0,3,5,9,12], target = 2
    //输出: -1
    //解释: 2 不存在 nums 中因此返回 -1


    public static void main(String[] args) {
        int[] array = {-1,0,3,5,9,12};

        System.out.println(search(array,-1));
        System.out.println(search(array,2));

    }

    public static int search(int arr[], int target) {

        int i=0;
        int j = arr.length - 1;
        int m=0;
        while (i<=j) {
            m = (i + j) >>> 1;
            if (arr[m] < target) {
                i=m+1;
            }else if (arr[m] > target){
                j = m - 1;
            }else {
                return m;
            }

        }

        return -1;
    }
}
