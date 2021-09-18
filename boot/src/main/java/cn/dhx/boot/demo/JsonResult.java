package cn.dhx.boot.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class JsonResult {


    protected String code;
    protected boolean success;
    protected String message;
    private Object data;


    protected JsonResult() {
    }

    protected JsonResult(boolean success, String message) {
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

//    public static JsonResult success(ResultEnum resultEnum) {
//        return new JsonResult(resultEnum.getCode(),true, resultEnum.getMessage());
//    }
//
//    public static JsonResult success(String code, boolean success, String message,Object data) {
//        return new JsonResult(code,true, message,data);
//    }
//
//    public static JsonResult failed(ResultEnum resultEnum) {
//        return new JsonResult(resultEnum.getCode(),false, resultEnum.getMessage());
//    }



}
