package cn.dhx.boot.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ExecuteResult {
    private boolean success;
    private String message;
    private Exception e;

    public static ExecuteResult success(String message) {
        return new ExecuteResult(true, message, null);
    }

    public static ExecuteResult failed(Exception e) {
        return new ExecuteResult(false, e.getMessage(), e);
    }

    public static ExecuteResult failed(String message) {
        return new ExecuteResult(false, message, new Exception(message));
    }

    private ExecuteResult(boolean success, String message, Exception e) {
        this.success = success;
        this.message = message;
        this.e = e;
    }

}
