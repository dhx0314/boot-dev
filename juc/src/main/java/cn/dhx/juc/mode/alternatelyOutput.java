package cn.dhx.juc.mode;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/5/16 22:43
 * 交替输出  aabbcc aabbcc
 */
@Slf4j
public class alternatelyOutput {

    public static void main(String[] args) {
        SyncWaitNotify syncWaitNotify = new SyncWaitNotify(1,5);
        new Thread(()->{
            syncWaitNotify.print(1,2,"aa");
        }).start();
        new Thread(()->{
            syncWaitNotify.print(2,3,"bb");
        }).start();
        new Thread(()->{
            syncWaitNotify.print(3,1,"cc");
        }).start();

    }

}

@Slf4j
@Data
class SyncWaitNotify {

    private int flag;

    private int loopNumber;

    public SyncWaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(int waitFlag, int nextFlag, String str) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (this.flag != waitFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
                log.info("message {}", str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
