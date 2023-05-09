package cn.dhx.juc.thread.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


@Slf4j
public class MyInterrupted2 {

    public static void main(String[] args) throws InterruptedException {
        TowPhaseTermination towPhaseTermination = new TowPhaseTermination();
        towPhaseTermination.start();
        TimeUnit.SECONDS.sleep(4);
        towPhaseTermination.stop();
    }

}


@Slf4j
class TowPhaseTermination{
    private Thread monitor;

    public void start() {
        monitor=new Thread(()->{
            while (true){
                Thread thread = Thread.currentThread();
                if (thread.isInterrupted()) {
                    log.info("interrupt");
                    break;
                }else {
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

    public void stop(){
        monitor.interrupt();
    }
}
