package cn.dhx.boot.delayqueue.jvm;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/7/17 9:58
 */
@Slf4j
@Data
@NoArgsConstructor
public class OrderDelayObject implements Delayed {

    private Long orderId;

    private long delayTime;

    private String message;

    public OrderDelayObject(Long orderId, long delayTime, String message) {
        this.orderId = orderId;
        this.delayTime = System.currentTimeMillis() + delayTime;
        this.message = message;
    }


//     获取任务剩余时间
    @Override
    public long getDelay(@NotNull TimeUnit unit) {
        long diff = this.delayTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(@NotNull Delayed o) {
        return Long.compare(this.delayTime, ((OrderDelayObject) o).delayTime);

    }
}
