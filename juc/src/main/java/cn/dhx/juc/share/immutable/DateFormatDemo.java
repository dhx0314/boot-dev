package cn.dhx.juc.share.immutable;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/28 15:02
 */
@Slf4j
public class DateFormatDemo {


    //线程不安全
    @Test
    public void simpleDateFormat() throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    Date parse = sdf.parse("2023-05-28");
                    log.info("date {}",parse);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(10);
    }


    @Test
    public void DateTimeFormatter() throws InterruptedException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    TemporalAccessor parse = dtf.parse("2023-05-28");
                    log.info("date {}",parse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(10);
    }



}
