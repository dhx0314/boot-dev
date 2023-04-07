package cn.dhx.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author : zhouhailin
 * @version 1.0.0
 */
@Data
@Accessors(chain = true)
public class Response {
    private int code;
    private String message;
    private Object data;
}
