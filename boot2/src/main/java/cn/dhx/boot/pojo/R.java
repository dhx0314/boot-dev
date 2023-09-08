package cn.dhx.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/7/20 14:13
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R{
    private Boolean flag;
    private Object data;
    private String msg;		//用于封装消息
}
