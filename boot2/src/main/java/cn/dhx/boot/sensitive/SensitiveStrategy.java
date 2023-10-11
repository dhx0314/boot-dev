package cn.dhx.boot.sensitive;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * @Author daihongxin
 * @create 2023/10/11 15:47
 */
@Slf4j
public enum SensitiveStrategy {

    /**
     * 用户名
     */
    USERNAME(s -> s.replaceAll("(\\S)\\S(\\S*)", "$1*$2")),
    /**
     * 身份证
     */
    ID_CARD(s -> s.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1****$2")),
    /**
     * 手机号
     */
    PHONE(s -> s.replaceAll("(\\d{3})\\d*(\\d{4})", "$1****$2")),
    /**
     * 地址
     */
    ADDRESS(s -> s.replaceAll("(\\S{3})\\S{2}(\\S*)\\S{2}", "$1****$2****"));

    private final Function<String, String> desensitize;

    SensitiveStrategy(Function<String, String> desensitize) {
        this.desensitize = desensitize;
    }
    public Function<String, String> desensitize() {
        return desensitize;
    }
}
