package cn.dhx.algorithm.data_structure.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @Author daihongxin
 * @create 2023/8/18 16:21
 */
@Slf4j
public class ArrayDemo {


    @Test
    public void fun1() {
        int[] arr={1, 2, 3};
        System.out.println(arr.length);

    }


    public static void main(String[] args) {
        int rows = 1000000;
        int columns = 14;
        int[][] a = new int[rows][columns];

        StopWatch sw = new StopWatch();
        sw.start("ij");
        ij(a, rows, columns);
        sw.stop();
        sw.start("ji");
        ji(a, rows, columns);
        sw.stop();
        System.out.println(sw.prettyPrint());
    }




    public static void ij(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }


    public static void ji(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }
}
