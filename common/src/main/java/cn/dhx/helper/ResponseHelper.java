package cn.dhx.helper;


import cn.dhx.pojo.Response;


/**
 * @author : zhouhailin
 * @version 1.0.0
 */
public class ResponseHelper {

    public static Response ok(Object data) {
        return new Response().setData(data).setCode(200).setMessage("OK");
    }

    public static Response ok() {
        return new Response().setCode(200).setMessage("OK");
    }

    public static Response failed(String message) {
        return new Response().setCode(400).setMessage(message);
    }

    public static Response failed(int code, String message) {
        return new Response().setCode(code).setMessage(message);
    }
}
