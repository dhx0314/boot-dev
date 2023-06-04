package cn.dhx.juc.juc.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/6/4 17:33
 */
@Slf4j
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        new Thread(() -> {
            list.remove(0);
            System.out.println(list);

        }).start();
        TimeUnit.SECONDS.sleep(1);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
