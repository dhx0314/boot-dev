package cn.dhx.juc.share.unlocked.cas.cas;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author daihongxin
 * @create 2023/5/24 14:24
 */
@Slf4j
public class AtomicIntegerFieldUpdaterDemo {

    public static void main(String[] args) {
        FiledTest filedTest = new FiledTest();
        filedTest.setSafe(100);
        filedTest.setSafe(100);
    }
}

@Data
class FiledTest {

    public String name;

    private volatile int fieldInt;

    public void setSafe(int num) {
        AtomicIntegerFieldUpdater<FiledTest> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(FiledTest.class, "fieldInt");
        fieldUpdater.compareAndSet(this, fieldUpdater.get(this),  num);
        System.out.println(this.getFieldInt());
    }

}
