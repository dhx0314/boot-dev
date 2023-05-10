package cn.dhx;

import cn.dhx.boot.helper.ExecutorHelper;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.NamedThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.concurrent.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ExecutorTest {


    //2023-04-26 21:27:20   FixedRate
    //2023-04-26 21:27:25   FixedRate
    //2023-04-26 21:27:30   FixedRate
    //2023-04-26 21:27:35   FixedRate
    @Test
    public void scheduleAtFixedRate() throws InterruptedException {
        ExecutorHelper.scheduleAtFixedRate(() -> {
            System.out.println(DateUtil.now() + "   FixedRate");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 5, TimeUnit.SECONDS);


        TimeUnit.SECONDS.sleep(1000);

    }

    //2023-04-26 21:28:10   FixedDelay
    //2023-04-26 21:28:18   FixedDelay
    //2023-04-26 21:28:26   FixedDelay
    //2023-04-26 21:28:34   FixedDelay
    @Test
    public void scheduleWithFixedDelay() throws InterruptedException {
        ExecutorHelper.scheduleWithFixedDelay(() -> {
            System.out.println(DateUtil.now() + "   FixedDelay");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, 1, 5, TimeUnit.SECONDS);


        TimeUnit.SECONDS.sleep(1000);
    }
}
