package cn.dhx.util;

import cn.hutool.core.util.StrUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author daihongxin
 * @create 2023/4/4 16:20
 */
public class EncryPhoneNumberUtil {

    public static String encryPhoneNumber(String text) {
        if (StrUtil.isBlank(text)) {
            return "";
        }
        String regex = "(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])(\\d{4})(\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("$1****$3");
    }

}
