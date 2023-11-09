package cn.dhx.boot.completablefuture;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author daihongxin
 * @create 2023/11/7 11:35
 */
@Slf4j
public class CompletableFutureDemo {

    ExecutorService executor = Executors.newFixedThreadPool(10);

    @Test
    public void FutureTask() throws Exception {
        // FutureTask
        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            log.info("future task");
            TimeUnit.SECONDS.sleep(3);
            return "ok";
        });
        new Thread(futureTask1, "BB").start();
        log.info("done {}", futureTask1.isDone());
        log.info("futureTask1.get() {}", futureTask1.get());
        log.info("done {}", futureTask1.isDone());

    }


    @Test
    public void supplyAsync() throws Exception {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("start");
            return "ok";
        }, executor);


        log.info("result {}", stringCompletableFuture.get());

    }

    @Test
    public void supplyAsyncException() throws Exception {
        CompletableFuture<Integer> start = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程: " + Thread.currentThread().getId());
            int i = 10 / 0;
            System.out.println("运行结果：" + i);
            return i;
        }, executor).whenComplete((result, exception) -> {
            log.info("result {} exception {} ", result, exception);
        });


        log.info("start get {} ", start.get());
        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    public void fun2() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程: " + Thread.currentThread().getId());
            int i = 10 / 0;
            System.out.println("运行结果：" + i);
            return i;
        }, executor).whenComplete((result, exception) -> {
            // 虽然能得到异常信息，但是没法修改返回数据
            System.out.println("异步任务成功完成了...结果是：" + result + ";异常是：" + exception);
        }).exceptionally(throwable -> {
            // 可以感知异常同时返回指定默认值
            return 10;
        });
        System.out.println(future2.get());

        System.out.println("main...end....");
    }


    @Test
    public void allOf() throws Exception {
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            log.info("start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok future2";
        }, executor);

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            log.info("start");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok future2";
        }, executor);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future2, future3);
        voidCompletableFuture.get();
        log.info("future3 {}", future3.get());
        log.info("future2 {}", future2.get());

    }

    @Test
    public void fun3() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            Thread currentThread = Thread.currentThread();
            String ThreadName = currentThread.getName();
            String taskName = "task1";
            System.out.println(ThreadName + "开始执行任务：" + taskName);
            System.out.println("正在执行任务" + taskName);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(taskName + "执行结束");
            return taskName;
        }, executor)
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> {
                            Thread currentThread = Thread.currentThread();
                            String ThreadName = currentThread.getName();
                            String taskName = "task2";
                            System.out.println(ThreadName + "开始执行任务：" + taskName);
                            System.out.println("正在执行任务" + taskName);
                            try {
                                TimeUnit.SECONDS.sleep(2);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(taskName + "执行结束");
                            return taskName;
                        }, executor),
                        (task1Result, task2Result) -> {
                            Thread currentThread = Thread.currentThread();
                            String ThreadName = currentThread.getName();
                            String taskName = "task3";
                            System.out.println(ThreadName + "开始执行任务：" + taskName);
                            System.out.println("task1结果：" + task1Result + "\ttask2结果：" + task2Result);
                            System.out.println("正在执行任务" + taskName);
                            System.out.println(taskName + "执行结束");
                            return taskName;
                        });
        String s = stringCompletableFuture.get();
        System.out.println(s);


    }
}
