package cn.dhx.boot.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class JsonResult {
    public static final JsonResult SUCCESS = success("success");
    public static final JsonResult INVALID = failed("参数错误");
    public static final JsonResult DISABLED = failed("功能未启用");
    public static final JsonResult UNKNOWN_ERROR = failed("系统错误");
    public static final JsonResult USE_MPS_ERROR = failed("使用的mps异常");
    public static final JsonResult MPS_USE = failed("deviceId already matches MPS");
    public static final JsonResult MPS_LOCK = failed("not get lock");

    protected boolean success;
    protected String message;

    public JsonResult() {
    }

    protected JsonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static JsonResult success(String message) {
        return new JsonResult(true, message);
    }

    public static JsonResult failed(String message) {
        return new JsonResult(false, message);
    }

//    @Override
//    public String toString() {
//        return JsonUtil.toString(this);
//    }


}
