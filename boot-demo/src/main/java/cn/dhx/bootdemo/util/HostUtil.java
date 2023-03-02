package cn.dhx.bootdemo.util;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author daihongxin
 * @create 2023/3/1 20:33
 */
@Slf4j
public class HostUtil {

    private static String hostName;

    static {
        hostName = getHost();
        log.info("hostName {}",hostName);
    }

    public static String getHost() {
        String hostAddress = "";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {

        }
        return hostAddress;
    }

    public static String getHostName() {
        return hostName;
    }
}
