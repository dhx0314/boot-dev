package cn.dhx.boot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Author daihongxin
 * @create 2023/3/30 16:48
 */

@Component
@Slf4j
public class RoundRobinUtil {


    public static ArrayList<String> arrayList = new ArrayList<>();

    static {
        arrayList.add("aa");
        arrayList.add("bb");
        arrayList.add("cc");
    }

    private static int index = 0;

    private static final int MAX = 100000;

    public static String selectUri() {
        index++;
        if (index > MAX) {
            index = 0;
        }
        int serverIndex = index % arrayList.size();
        return arrayList.get(serverIndex);
    }

    public static int  getSize() {
        return arrayList.size();
    }


}
