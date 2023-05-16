package cn.dhx.juc.mode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


/**
 * 两阶段终止模式
 * 在一个线程 T1 中如何“优雅”终止线程 T2？这里的【优雅】指的是给 T2 一个料理后事的机会。
 */
@Slf4j
public class TowPhaseTerminationDemo {

    public static void main(String[] args) throws InterruptedException {
        TowPhaseTermination towPhaseTermination = new TowPhaseTermination();
        towPhaseTermination.start();
        TimeUnit.SECONDS.sleep(4);
        towPhaseTermination.stop();
    }

}


@Slf4j
class TowPhaseTermination {
    private Thread monitor;

    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread thread = Thread.currentThread();
                if (thread.isInterrupted()) {
                    log.info("interrupt");
                    break;
                } else {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        log.info("monitor");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        thread.interrupt();
                    }
                }
            }
        });

        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }
}
