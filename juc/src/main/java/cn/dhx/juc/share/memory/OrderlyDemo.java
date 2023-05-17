package cn.dhx.juc.share.memory;


/**
 * @Author daihongxin
 * @create 2023/5/17 15:03
 */
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;


@Slf4j
@JCStressTest
@State
@Outcome(id = {"1", "4"}, expect = Expect.ACCEPTABLE, desc = "true")
@Outcome(id = "0", expect = Expect.ACCEPTABLE_INTERESTING, desc = "false")
public class OrderlyDemo {

    /**
     * 结果有三种可能 4， 1，0(这个0是因为指令重排）
     */
    private int num = 0;
//    private boolean ready = false;
    private volatile boolean ready = false;

    @Actor
    public void method(I_Result result) {
        if (ready) {
            result.r1 = num + num;
        } else {
            result.r1 = 1;
        }
    }

    @Actor
    public void method2(I_Result result) {
        num = 2;               //这个地方有可能会发生指令重排，也就是a=2和flag=true互换
        ready = true;
    }

}

