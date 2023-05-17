package cn.dhx.juc.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/5/17 9:52
 * Balking （犹豫）模式用在一个线程发现另一个线程或本线程已经做了某一件相同的事，那么本线程就无需再做
 * 了，直接结束返回
 */
@Slf4j
public class BalkingDemo {

    public static void main(String[] args) {
        MonitorService monitorService = new MonitorService();
        for (int i = 0; i < 10; i++) {
            monitorService.start();
        }
    }
}



@Slf4j
class MonitorService{
    private volatile boolean starting;


    public void start() {
        log.info("start");
        synchronized (this) {
            if (starting) {
                return;
            }
            log.info("doing");
            starting = true;
        }
    }

}