package cn.dhx.juc.share.monitor.synchronize.lock;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * @Author daihongxin
 * @create 2023/5/23 21:13
 */
@Slf4j
public class MyClassLayout {

    static String printMarkDown(Object instance){
        String[] split = ClassLayout.parseInstance(instance).toPrintable().split("\\r\\n");
        String s = split[2];
        return s.substring(60,s.length());
    }
}
