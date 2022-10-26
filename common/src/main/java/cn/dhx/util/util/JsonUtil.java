package cn.dhx.util.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        //忽略无法识别的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //支持用数组接收单个元素
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        // 序列化时使用属性而不是set,get方法
        mapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public static String toString(Object object) {
        String json = null;
        try {
            json = mapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("parse Object to JSON String ERROR!", e);
        }
        return json;
    }

    public static <T> T toObject(String json, Class<T> valueType) {
        try {
            return mapper.readValue(json, valueType);
        } catch (Exception e) {
            log.error("parse String to Java Object ERROR!", e);
            return null;
        }
    }

    public static <T> T toObject(String json, TypeReference<T> valueType) {
        try {
            return mapper.readValue(json, valueType);
        } catch (Exception e) {
            log.error("parse String to Java Object ERROR!", e);
            return null;
        }
    }

    public static JsonNode toObject(String json) {
        try {
            return mapper.readTree(json);
        } catch (Exception e) {
            log.error("parse String to JsonNode ERROR!", e);
            return null;
        }
    }

    public static <T> T convertObject(Object object, Class<T> valueType) {
        if (object != null && valueType != null) {
            return toObject(toString(object), valueType);
        }
        return null;
    }

    public static <T> T convertObject(Object object, TypeReference<T> valueType) {
        if (object != null && valueType != null) {
            return toObject(toString(object), valueType);
        }
        return null;
    }

}
