package cn.dhx.pojo;

import cn.dhx.enums.CallDirectEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author daihongxin
 * @create 2023/4/4 15:00
 */
@Data

public class Stu2 {

    String callDirectEnum2;
    CallDirectEnum callDirectEnum;
    String id;

    public Stu2() {
    }

    public Stu2(CallDirectEnum callDirectEnum, String id) {
        this.callDirectEnum = callDirectEnum;
        this.id = id;
    }
}
