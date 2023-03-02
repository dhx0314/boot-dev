package cn.dhx.bootdemo.demo;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo01 {

    public String long2String(long l1) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(l1);
        Date time = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datef = sdf.format(time);
        return datef;
    }

    @Test
    public void fun1() {
        long l = System.currentTimeMillis();
        System.out.println(long2String(l));
        long add_8 = 24 * 3600 * 1000;
        long l1 = l + add_8;
        System.out.println(long2String(l1));
    }


    @Test
    public void fun2() {
        AtomicInteger currentPoolSize = new AtomicInteger(0);
        currentPoolSize.incrementAndGet();
        System.out.println(currentPoolSize.get());
        System.out.println(currentPoolSize.get());
        currentPoolSize.getAndIncrement();
        System.out.println(currentPoolSize.get());
    }


    @Test
    public void fun3() {
        byte[] voiceBytes=new byte[4];
        voiceBytes[0]=1;
        voiceBytes[1]=2;
        voiceBytes[2]=3;

        byte[] voiceBytes2 = new byte[voiceBytes.length];
        System.arraycopy(voiceBytes,0,voiceBytes2,0,voiceBytes2.length);
        voiceBytes[1]=11;

        System.out.println(Arrays.toString(voiceBytes));
        System.out.println(Arrays.toString(voiceBytes2));

//        System.out.println(this.getClass().get);
    }
}
