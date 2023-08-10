package cn.dhx.boot.disruptor;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/7/31 10:57
 */
@Slf4j
public class EventHandlerImpl implements EventHandler<Event> {


    @Override
    public void onEvent(Event event, long l, boolean b) throws Exception {
//        System.out.println("消费者处理Event：" + event.getId() + " " + event.getName());


        log.info("consumer Event {} {}",event.getId(),event.getName());
    }
}
