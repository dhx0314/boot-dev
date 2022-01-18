package cn.dhx.boot.pojo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class RTVoiceRequest extends LinkedHashMap<String, String> {


    private String callId;

    private String deviceId;

    private static final List<String> hideKeys = Arrays.asList("caller", "callee");

    public Integer getIntegerValue(String key) {
        if (StringUtils.isNotEmpty(key)) {
            String value = get(key);
            if (StringUtils.isNotEmpty(value)) {
                return Integer.parseInt(value);
            }
        }
        return null;
    }

    public int getIntegerValue(String key, int defaultValue) {
        Integer value = getIntegerValue(key);
        return value == null ? defaultValue : value;
    }

    public Long getLongValue(String key) {
        if (StringUtils.isNotEmpty(key)) {
            String value = get(key);
            if (StringUtils.isNotEmpty(value)) {
                return Long.parseLong(value);
            }
        }
        return null;
    }

    public long getLongValue(String key, long defaultValue) {
        Long value = getLongValue(key);
        return value == null ? defaultValue : value;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        return "RTVoiceRequest{" +
                "callId='" + callId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
