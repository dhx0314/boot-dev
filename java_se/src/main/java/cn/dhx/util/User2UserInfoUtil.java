package cn.dhx.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapBuilder;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.json.JSONUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 明文：a=b;b=c;c=d;encoding=text
 * JSON: {“x”:”x”};encoding=json
 * HEX编码：xxxx;encoding=hex
 * Base64编码：xxxx;encoding=base64
 * <p>
 * 依赖 hutool-all工具包
 *
 * @author zhouhailin
 */
public class User2UserInfoUtil {

    private static final String TEXT = "text";
    private static final String JSON = "json";
    private static final String HEX = "hex";
    private static final String BASE64 = "base64";
    private static final String TEXT_HEX = "textHex";
    private static final String TEXT_BASE64 = "textBase64";
    private static final String JSON_HEX = "jsonHex";
    private static final String JSON_BASE64 = "jsonBase64";

    private static final String ENCODING_MARK = ";encoding=";

    private static final char TEXT_SPLIT_CHAR = ';';

    private static final Map<String, Object> EMPTY_MAP = Collections.unmodifiableMap(new HashMap<>(4));

    private User2UserInfoUtil() {
    }

    /**
     * MapBuilder.<String, Object>create().put("a", 1).put("b", "b1=xx").put("c", 2L).put("d", 'c').put("我和", "我的祖国").build();
     * <p>
     * <br/>
     * <p>
     * a=1;b=b1=xx;c=2;d=c;我和=我的祖国;encoding=text
     *
     * @param map 编码对象
     * @return 编码结果
     */
    public static String encodeMap2Text(Map<String, Object> map) {
        Assert.notEmpty(map);
        StringBuilder sb = new StringBuilder();
        map.forEach((key, val) -> sb.append(key).append("=").append(val).append(TEXT_SPLIT_CHAR));
        sb.deleteCharAt(sb.length() - 1);
        return sb.append(ENCODING_MARK + "text").toString();
    }

    /**
     * MapBuilder.<String, Object>create().put("a", 1).put("b", "b1=xx").put("c", 2L).put("d", 'c').put("我和", "我的祖国").build();
     * <p>
     * <br/>
     * <p>
     * {"a":1,"b":"b1=xx","c":2,"d":"c","我和":"我的祖国"};encoding=json
     *
     * @param map 编码对象
     * @return 编码结果
     */
    public static String encodeMap2Json(Map<String, Object> map) {
        Assert.notEmpty(map);
        return JSONUtil.toJsonStr(map) + ENCODING_MARK + JSON;
    }

    /**
     * MapBuilder.<String, Object>create().put("a", 1).put("b", "b1=xx").put("c", 2L).put("d", 'c').put("我和", "我的祖国").build();
     * <p>
     * <br/>
     * <p>
     * 613d313b623d62313d78783b633d323b643d633be68891e5928c3de68891e79a84e7a596e59bbd;encoding=textHex
     *
     * @param map 编码对象
     * @return 编码结果
     */
    public static String encodeMap2TextHex(Map<String, Object> map) {
        Assert.notEmpty(map);
        StringBuilder sb = new StringBuilder();
        map.forEach((key, val) -> sb.append(key).append("=").append(val).append(TEXT_SPLIT_CHAR));
        sb.deleteCharAt(sb.length() - 1);
        return HexUtil.encodeHexStr(sb.toString()) + ENCODING_MARK + TEXT_HEX;
    }

    /**
     * MapBuilder.<String, Object>create().put("a", 1).put("b", "b1=xx").put("c", 2L).put("d", 'c').put("我和", "我的祖国").build();
     * <p>
     * <br/>
     * <p>
     * YT0xO2I9YjE9eHg7Yz0yO2Q9YzvmiJHlkow95oiR55qE56WW5Zu9;encoding=textBase64
     *
     * @param map 编码对象
     * @return 编码结果
     */
    public static String encodeMap2TextBase64(Map<String, Object> map) {
        Assert.notEmpty(map);
        StringBuilder sb = new StringBuilder();
        map.forEach((key, val) -> sb.append(key).append("=").append(val).append(TEXT_SPLIT_CHAR));
        sb.deleteCharAt(sb.length() - 1);
        return Base64.encode(sb.toString()) + ENCODING_MARK + TEXT_BASE64;
    }

    /**
     * MapBuilder.<String, Object>create().put("a", 1).put("b", "b1=xx").put("c", 2L).put("d", 'c').put("我和", "我的祖国").build();
     * <p>
     * <br/>
     * <p>
     * 7b2261223a312c2262223a2262313d7878222c2263223a322c2264223a2263222c22e68891e5928c223a22e68891e79a84e7a596e59bbd227d;encoding=jsonHex
     *
     * @param map 编码对象
     * @return 编码结果
     */
    public static String encodeMap2JsonHex(Map<String, Object> map) {
        Assert.notEmpty(map);
        return HexUtil.encodeHexStr(JSONUtil.toJsonStr(map)) + ENCODING_MARK + JSON_HEX;
    }

    /**
     * MapBuilder.<String, Object>create().put("a", 1).put("b", "b1=xx").put("c", 2L).put("d", 'c').put("我和", "我的祖国").build();
     * <p>
     * <br/>
     * <p>
     * eyJhIjoxLCJiIjoiYjE9eHgiLCJjIjoyLCJkIjoiYyIsIuaIkeWSjCI6IuaIkeeahOelluWbvSJ9;encoding=jsonBase64
     *
     * @param map 编码对象
     * @return 编码结果
     */
    public static String encodeMap2JsonBase64(Map<String, Object> map) {
        Assert.notEmpty(map);
        return Base64.encode(JSONUtil.toJsonStr(map)) + ";encoding=jsonBase64";
    }

    /**
     * {a=1, b=b1=xx, c=2, d=c, 我和=我的祖国}
     * <p>
     * <br/>
     * <p>
     * 7b613d312c20623d62313d78782c20633d322c20643d632c20e68891e5928c3de68891e79a84e7a596e59bbd7d;encoding=hex
     *
     * @param data 编码数据
     * @return 编码结果
     */
    public static String encodeStr2Hex(String data) {
        Assert.notBlank(data);
        return HexUtil.encodeHexStr(data) + ";encoding=hex";
    }

    /**
     * {a=1, b=b1=xx, c=2, d=c, 我和=我的祖国}
     * <p>
     * <br/>
     * <p>
     * e2E9MSwgYj1iMT14eCwgYz0yLCBkPWMsIOaIkeWSjD3miJHnmoTnpZblm719;encoding=base64
     *
     * @param data 编码数据
     * @return 编码结果
     */
    public static String encodeStr2Base64(String data) {
        Assert.notBlank(data);
        return Base64.encode(data) + ";encoding=base64";
    }

    /**
     * Hex解码
     * <p>
     * 7b613d312c20623d62313d78782c20633d322c20643d632c20e68891e5928c3de68891e79a84e7a596e59bbd7d;encoding=hex
     * <p>
     * <br/>
     * <p>
     * {a=1, b=b1=xx, c=2, d=c, 我和=我的祖国}
     *
     * @param data 数据
     * @return 字符串
     */
    public static String decodeHex(String data) {
        String encoding = CharSequenceUtil.subAfter(data, ENCODING_MARK, true);
        if (CharSequenceUtil.isBlank(encoding)) {
            return null;
        }
        String data0 = CharSequenceUtil.subBefore(data, ENCODING_MARK, true);
        return HexUtil.decodeHexStr(data0);
    }

    /**
     * Base64解码
     * <p>
     * e2E9YTEsIGI9YjEsIGM9YzEsIOaIkeWSjD3miJHnmoTnpZblm719;encoding=base64
     * <p>
     * <br/>
     * <p>
     * {a=1, b=b1=xx, c=2, d=c, 我和=我的祖国}
     *
     * @param data 数据
     * @return 字符串
     */
    public static String decodeBase64(String data) {
        String encoding = CharSequenceUtil.subAfter(data, ENCODING_MARK, true);
        if (CharSequenceUtil.isBlank(encoding)) {
            return null;
        }
        String data0 = CharSequenceUtil.subBefore(data, ENCODING_MARK, true);
        return Base64.decodeStr(data0);
    }

    /**
     * 数据解码成map对象
     *
     * @param data 数据
     * @return map对象
     */
    public static Map<String, Object> decode(String data) {
        String encoding = CharSequenceUtil.subAfter(data, ENCODING_MARK, true);
        if (CharSequenceUtil.isBlank(encoding)) {
            return Collections.emptyMap();
        }
        String data0 = CharSequenceUtil.subBefore(data, ENCODING_MARK, true);
        switch (encoding) {
            case TEXT: {
                MapBuilder<String, Object> builder = MapBuilder.create();
                for (String str : CharSequenceUtil.split(data0, TEXT_SPLIT_CHAR)) {
                    String[] strs = CharSequenceUtil.splitToArray(str, '=', 2);
                    if (strs.length == 2) {
                        builder.put(strs[0], strs[1]);
                    }
                }
                return builder.build();
            }
            case JSON: {
                return JSONUtil.parseObj(data0);
            }
            case JSON_HEX: {
                String str = HexUtil.decodeHexStr(data0);
                return JSONUtil.parseObj(str);
            }
            case JSON_BASE64: {
                String str = Base64.decodeStr(data0);
                return JSONUtil.parseObj(str);
            }
            case TEXT_HEX: {
                MapBuilder<String, Object> builder = MapBuilder.create();
                for (String str : CharSequenceUtil.split(HexUtil.decodeHexStr(data0), TEXT_SPLIT_CHAR)) {
                    String[] strs = CharSequenceUtil.splitToArray(str, '=', 2);
                    if (strs.length == 2) {
                        builder.put(strs[0], strs[1]);
                    }
                }
                return builder.build();
            }
            case TEXT_BASE64: {
                MapBuilder<String, Object> builder = MapBuilder.create();
                for (String str : CharSequenceUtil.split(Base64.decodeStr(data0), TEXT_SPLIT_CHAR)) {
                    String[] strs = CharSequenceUtil.splitToArray(str, '=', 2);
                    if (strs.length == 2) {
                        builder.put(strs[0], strs[1]);
                    }
                }
                return builder.build();
            }
            case HEX:
            case BASE64:
            default:
                break;
        }
        return EMPTY_MAP;
    }

}
