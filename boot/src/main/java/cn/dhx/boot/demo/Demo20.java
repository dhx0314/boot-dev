package cn.dhx.boot.demo;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo20 {


    public final static BlockingQueue<byte[]> pkgQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {

        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode("11");
        System.out.println(jsonResult.toString());

    }
}
