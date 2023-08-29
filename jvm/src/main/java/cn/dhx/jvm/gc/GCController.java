package cn.dhx.jvm.gc;

import cn.dhx.jvm.gc.service.MyMath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author daihongxin
 * @create 2023/8/23 9:47
 */
@Slf4j
@RestController
public class GCController {


    @GetMapping("cpu")
    public void cpuFun() {
        new Thread(() -> {
            MyMath math = new MyMath();
            while (true) {
                math.compute();
            }
        }).start();

    }
}
