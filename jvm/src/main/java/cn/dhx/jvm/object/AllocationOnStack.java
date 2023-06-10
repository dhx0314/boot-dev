package cn.dhx.jvm.object;

import cn.dhx.jvm.pojo.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/6/11 0:28
 * 栈上分配，标量替换
 */
@Slf4j
public class AllocationOnStack {


    //  PrintGCDetail
    // -Xms30m -Xms30m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
    // -Xms30m -Xms30m -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        log.info("start");
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        log.info("cost {}", end - start);
    }

    public static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("aa");
    }
}
