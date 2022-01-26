package cn.dhx.boot.demo;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo20 {


    public final static BlockingQueue<Byte[]> pkgQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        byte[] bytes1 = new byte[2];
        bytes1[0]=0;
        bytes1[1]=1;
        byte[] bytes2 = new byte[2];
        bytes2[0]=2;
        bytes2[1]=3;
        byte[] bytes3 = new byte[2];
        bytes3[0]=4;
        bytes3[1]=5;
        byte[] bytes4 = new byte[2];
        bytes4[0]=6;
        bytes4[1]=7;
        int length=2;
        byte[] joinedArray = new byte[10];
        System.arraycopy(bytes1, 0, joinedArray, 0, length);
        System.arraycopy(bytes2, 0, joinedArray, length*1, length);
        System.arraycopy(bytes3, 0, joinedArray, length*2, length);
        System.arraycopy(bytes4, 0, joinedArray, length*3, length);
        System.out.println(Arrays.toString(joinedArray));

//        ArrayUtils.addAll(bytes1,bytes2,bytes3,bytes4)

    }
}
