package cn.dhx.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

import java.nio.charset.StandardCharsets;

public class MySecurityUtil {

    private static final String PASSWD_KEY="wilcomwilcom@123";

    private static  AES aes;
    static {
        byte[] bytes = PASSWD_KEY.getBytes(StandardCharsets.UTF_8);
        aes = SecureUtil.aes(bytes);
    }
    public static String encode(String str) {
        if (StrUtil.isBlank(str)) {
            return str;
        }
        return aes.encryptBase64(str);
    }

    public static String decode(String str) {
        if (StrUtil.isBlank(str)) {
            return str;
        }
        byte[] decode = Base64.decode(str);
        byte[] decrypt = aes.decrypt(decode);
        return new String(decrypt,StandardCharsets.UTF_8);
    }
}
