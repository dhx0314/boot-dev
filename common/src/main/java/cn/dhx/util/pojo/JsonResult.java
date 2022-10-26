package cn.dhx.util.pojo;

import cn.dhx.util.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JsonResult {

    protected String code;
    protected boolean success;
    protected String message;
    private Object data;


    public JsonResult() {
    }

    public JsonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public JsonResult(String code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }

    public JsonResult(String code, boolean success, String message, Object data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }


    @Override
    public String toString() {
        return JsonUtil.toString(this);
    }

}
