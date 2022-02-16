package cn.dhx.nettyvoice.entity;

import lombok.Data;

@Data
public class AudioStreamResp2 {

    // resultNo
    //  0	指令操作成功，并携带返回respCmd响应指令
    //  -1	json格式错误
    //  10000	参数为空错误。
    //  10001	主机或被叫错误，账号在系统中不存在
    //  10002	callid已在打开通话中，不可重复打开

    // 20000	callid参数为空错误。
    // 20001	Callid不存在或已关闭

    private int resultNo;

    private String resultDesc;

    private String respCmd;

    private String callid;

}
