package cn.dhx.juc.share.tool.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/28 22:44
 */
@Slf4j
public class ThreadPool {

    private BlockedQueue<Runnable> taskQueue;

    private HashSet<Worker> workers = new HashSet<>();


    private int coreSize;

    private long timeout;

    private TimeUnit timeUnit;

    private RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity, RejectPolicy<Runnable> rejectPolicy) {
        this.taskQueue = new BlockedQueue<>(queueCapacity);
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.rejectPolicy = rejectPolicy;
    }

    public void execute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                log.info("新增 worker {}    ,{}", worker, task);
                workers.add(worker);
                worker.start();
            }else {
                taskQueue.tryPut(rejectPolicy, task);
            }
        }
    }


    class Worker extends Thread {

        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while (task != null || (task = taskQueue.poll(timeout, timeUnit)) != null) {

                try {
                    log.info("run 正在执行 {}", task);
                    task.run();
                } catch (Exception e) {
                    log.error("error ", e);
                } finally {
                    task = null;
                }
            }
            synchronized (workers) {
                log.info("worker 被移除 {}", workers);
                workers.remove(this);
            }
        }
    }
}

