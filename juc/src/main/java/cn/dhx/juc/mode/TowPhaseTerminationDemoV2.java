package cn.dhx.juc.mode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/17 9:46
 * 两阶段终止
 */
@Slf4j
public class TowPhaseTerminationDemoV2 {


    public static void main(String[] args) throws InterruptedException {
        TowPhaseTermination2 towPhaseTermination2 = new TowPhaseTermination2();
        towPhaseTermination2.start();
        TimeUnit.SECONDS.sleep(3);
        towPhaseTermination2.stop();
    }
}


@Slf4j
class TowPhaseTermination2 {
    private Thread thread;
    private volatile boolean stop = false;

    public void start() {
        thread=new Thread(()->{
            while (true) {
                Thread thread = Thread.currentThread();
                if (stop) {
                    log.info("stop");
                    break;
                }

                try {
                    log.info("doing");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    public void stop(){
        stop = true;
        thread.interrupt();
    }
}