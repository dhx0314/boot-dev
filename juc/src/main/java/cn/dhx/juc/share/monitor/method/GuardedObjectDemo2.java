package cn.dhx.juc.share.monitor.method;

import jdk.internal.util.xml.impl.ReaderUTF8;
import lombok.Data;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import javax.swing.plaf.TableHeaderUI;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/14 13:51
 * 多线程版本
 */
@Slf4j
public class GuardedObjectDemo2 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(new People()).start();
        }
        TimeUnit.SECONDS.sleep(1);
        Set<Integer> ids = Mailboxes.getIds();
        for (Integer id : ids) {
            PostMan postMan = new PostMan(id, "内容" + id);
            new Thread(postMan).start();
        }
    }
}


@Slf4j
class People implements Runnable{

    @Override
    public void run() {
        GuardedObject2 guardedObject2 = Mailboxes.createGuardedObject2();
        log.info("start receive id {}", guardedObject2.getId());
        Object mail = guardedObject2.get(5000);
        log.info("end receive id {} message {}", guardedObject2.getId(), mail);

    }
}


@Data
@Slf4j
class PostMan implements Runnable{

    private int id;
    private String mail;

    public PostMan(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        GuardedObject2 guardedObject2ById = Mailboxes.getGuardedObject2ById(id);
        log.info("send id {} message {}", id, mail);
        guardedObject2ById.complete(mail);
    }
}



class Mailboxes {

    private static ConcurrentHashMap<Integer, GuardedObject2> boxes = new ConcurrentHashMap<>();

    private static int id = 1;

    private static synchronized int generatedId() {
        return id++;
    }

    public static GuardedObject2 getGuardedObject2ById(int id) {
        return boxes.remove(id);
    }

    public static GuardedObject2 createGuardedObject2() {
        GuardedObject2 guardedObject2 = new GuardedObject2(generatedId());
        boxes.put(guardedObject2.getId(), guardedObject2);
        return guardedObject2;
    }

    public static Set<Integer> getIds() {
        return boxes.keySet();
    }
}

@Slf4j
@Data
class GuardedObject2 {

    private int id;
    private Object response;
    private final Object lock = new Object();

    public GuardedObject2(int id) {
        this.id = id;
    }

    public Object get(long timeout) {
        synchronized (lock) {
            long begin = System.currentTimeMillis();
            long timePassed = 0;//已经经历的时间
            while (response == null) {

                //处理虚假唤醒的时间
                long waitTime = timeout - timePassed;
                if (waitTime <= 0) {
                    log.info("break");
                    break;
                }


                try {
                    lock.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                timePassed = System.currentTimeMillis() - begin;
//                log.info("timePassed {},response is  {}", timePassed, response);
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (lock) {
            this.response = response;
            log.info("notify");
            lock.notifyAll();
        }
    }

}
