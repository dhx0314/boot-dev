package cn.dhx.boot.pojo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class RTVoiceRequest {


    private String callId;

    private String deviceId;

    private Integer integer;

    private int anInt;
}
