package cn.dhx.juc.share.monitor.method;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/14 20:55
 * 生产者消费者
 */
@Slf4j
public class MessageQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        MessageQueue messageQueue = new MessageQueue(3);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(()->{
                Message message = new Message(finalI, "消息" + finalI);
                messageQueue.put(message);
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            while (true) {
                Message take = messageQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者").start();
    }
}


@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
class Message{

    private int id;
    private String message;


}

@Slf4j
class MessageQueue{

    private LinkedList<Message> queue;
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public Message take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                log.info("队列为空 wait");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = queue.remove();
            log.info("消费消息 {}", message);
            queue.notifyAll();
            return message;
        }
    }

    public void put(Message message) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                log.info("队列满了 wait");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("添加消息 {}",message);
            queue.addLast(message);
            queue.notifyAll();
        }

    }
}