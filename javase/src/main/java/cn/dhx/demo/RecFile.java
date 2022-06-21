package cn.dhx.demo;


import lombok.Data;

import java.util.Date;

@Data
public class RecFile {
    private String ani;            //	主叫
    private String dnis;        //	被叫
    private String startTime;        //	开始时间
    private String endTime;        //	结束时间
    private String callId;        //	callid
    private String contactId; // contactId
    private String fileId;        //	录音录音文件id,逗号隔开
    private String fileName;    //	混音文件名称
    private String customFileName;    //	客户端文件名称
    private String agentFileName;    //	坐席端文件名称
    private String fileInfo;    //	录音文件信息，对应recfileinfo表id,包括混合录音文件id和分离文件id,逗号隔开
    private String deviceId;    //	录音设备号码
    private String agentId;        //	录音设备对应工号
    private String recLength;        //	录音时长
    private String recordType;    //	录音类型 station/ivr
    private String callDirect;    // 	呼叫方向
    private String serverName;    //	服务器名称
    private String encodeType;      // 混合录音编码
    private String separableEncodeType;  // 分离录音编码
    private String appName;
    private String serviceStatus;//服务状态 Active/Standby
    private String sessionId;


}