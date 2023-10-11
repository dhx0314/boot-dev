package cn.dhx.boot.sensitive;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/10/11 15:52
 */
@Slf4j
@Data
public class Person {

    /**
     * 真实姓名
     */
    @Sensitive(strategy = SensitiveStrategy.USERNAME)
    private String realName;
    /**
     * 地址
     */
    @Sensitive(strategy = SensitiveStrategy.ADDRESS)
    private String address;
    /**
     * 电话号码
     */
    @Sensitive(strategy = SensitiveStrategy.PHONE)
    private String phoneNumber;
    /**
     * 身份证号码
     */
//    @Sensitive(strategy = SensitiveStrategy.ID_CARD)
    private String idCard;

}
