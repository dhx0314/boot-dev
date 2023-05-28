package cn.dhx.juc.share.tool.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author daihongxin
 * @create 2023/5/28 23:25
 */
@Slf4j
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
    }
}
