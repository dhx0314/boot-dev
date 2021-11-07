package cn.dhx.boot.demo;

import java.util.Random;
import java.util.concurrent.*;

public class Demo07 {

//    private static ExecutorService es = new ThreadPoolExecutor(50, 100, 0L, TimeUnit.MILLISECONDS,
//            new LinkedBlockingQueue<Runnable>(100000));

    private static ExecutorService es = Executors.newFixedThreadPool(50);

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 200; i++) {
            es.execute(() -> {
//                System.out.print(1);
                try {
                    Random random = new Random();
                    int i1 = random.nextInt(20);
                    TimeUnit.SECONDS.sleep(i1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) es);

        while (true) {
            System.out.println();

            int queueSize = tpe.getQueue().size();
            System.out.println("当前排队线程数：" + queueSize);

            int activeCount = tpe.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);

            long completedTaskCount = tpe.getCompletedTaskCount();
            System.out.println("执行完成线程数：" + completedTaskCount);

            long taskCount = tpe.getTaskCount();
            System.out.println("总线程数：" + taskCount);

            Thread.sleep(3000);
        }

    }
}
