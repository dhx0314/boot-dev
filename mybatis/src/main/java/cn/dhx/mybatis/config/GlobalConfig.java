package cn.dhx.mybatis.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@ConfigurationProperties
public class GlobalConfig {
    public static String PROJECT_NAME;
    public static String PROJECT_VERSION;
    public static int PORT;
    public static String MAC_ADDR;
    public static String IP_PREFIX;
    public static String LOCAL_IP;
    public static boolean VAD_ENABLE;
    public static int VAD_MODE;
    public static String VAD_LIBRARY_HOME;
    public static long SESSION_TIMEOUT;
    public static String AUDIO_FILE_SAVED_TYPE;
    public static int AUDIO_FILE_SAVED_DAYS;
    public static String AUDIO_FILE_SAVED_PATH;
    public static String[] EXCLUDE_IP_LIST;

    @SneakyThrows
    @PostConstruct
    public void init() {
        printVersion();

//        LOCAL_IP = IpaddrUtil.getIpv4(IP_PREFIX);
//        if (LOCAL_IP == null) {
//            throw new Exception("! cannot get ipv4 !!!");
//        }
//
//        if (!WebRTCVad.isValidVadMode(VAD_MODE)) {
//            throw new Exception("Invalid VAD mode : " + VAD_MODE);
//        }
//        // 初始化VAD
//        if (com.wilcom.wvr.vord.config.GlobalConfig.VAD_ENABLE) {
//            WebRTCVad.init();
//        }
//        // 启动抓包
//        PcapUtil.startCapture();
    }

    @Value("${project.name}")
    void setProjectName(String name) {
        PROJECT_NAME = name;
    }

    @Value("${project.version}")
    void setProjectVersion(String version) {
        PROJECT_VERSION = version;
    }

    @Value("${server.port}")
    void setPort(int port) {
        PORT = port <= 0 ? 8082 : port;
    }

    void setMacAddr(String addr) {
        MAC_ADDR = addr.trim().replace("-", ":");
    }

    void setIpPrefix(String prefix) {
        IP_PREFIX =  prefix.trim();
    }

//    @Value("${sessionTimeout}")
    void setSessionTimeout(long timeout) {
        SESSION_TIMEOUT = timeout < 5000 ? 5000 : timeout;
    }

    void setVadEnable(int enable) {
        VAD_ENABLE = enable == 1;
    }

    void setVadMode(int mode) {
        VAD_MODE = mode;
    }

    void setVadLibraryHome(String path) {
        if (path != null) {
            path = path.trim();
            if (path.length() > 0) {
                VAD_LIBRARY_HOME = path;
                log.info(">>> vad library home: " + path);
            }
        }
    }

    void setAudioFileSavedType(String type) {
        AUDIO_FILE_SAVED_TYPE = type;
        AUDIO_FILE_SAVED_TYPE = "pcm".equals(AUDIO_FILE_SAVED_TYPE) ? "pcm" : "wav";
    }

    void setAudioFileSavedDays(int days) {
        AUDIO_FILE_SAVED_DAYS = days < 1 ? 1 : days;
    }

    void setAudioFileSavedPath(String path) {
        AUDIO_FILE_SAVED_PATH = path;
        AUDIO_FILE_SAVED_PATH = AUDIO_FILE_SAVED_PATH.endsWith("/") ? AUDIO_FILE_SAVED_PATH : AUDIO_FILE_SAVED_PATH + "/";
    }

    void setExcludeIpList(String[] list) {
        EXCLUDE_IP_LIST = list;
    }

    private void printVersion() {
        log.info("=============================================");
        log.info("== PROJECT VERSION: {}", PROJECT_VERSION);
        log.info("=============================================");
    }
}