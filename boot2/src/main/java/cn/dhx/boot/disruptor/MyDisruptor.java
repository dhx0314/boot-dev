package cn.dhx.boot.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/7/31 11:13
 */
@Slf4j
@Component
public class MyDisruptor {


    Disruptor<Event> disruptor;

    @PostConstruct
    public void start() {

        EventFactory<Event> factory = Event::new;

        ThreadFactory threadFactory = new ThreadFactory() {
            int i = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "disruptor" + String.valueOf(i++));
            }
        };

        int bufferSize = 1024;
        disruptor = new Disruptor<>(factory, bufferSize, threadFactory);

        EventHandlerImpl eventHandler = new EventHandlerImpl();
        EventHandler<Event> eventHandler2 = new EventHandler<Event>() {
            @Override
            public void onEvent(Event event, long sequence, boolean endOfBatch) throws Exception {
                log.info("consumer22222 Event {} {}",event.getId(),event.getName());
            }
        };
        disruptor.handleEventsWith(eventHandler,eventHandler2);

        disruptor.start();

    }

    public void produce() {
        RingBuffer<Event> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();
        try {
            Event event = ringBuffer.get(sequence);
            event.setId(1);
            event.setName("test");
        } finally {
            ringBuffer.publish(sequence);
        }
    }

    public void produce2(int id, String message) {
        disruptor.publishEvent((event, sequence) -> {
            event.setId(id);

            event.setName(message);
        });
    }
}
