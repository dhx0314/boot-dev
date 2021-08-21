package cn.dhx.redispool.entity;


import lombok.Data;

@Data
public class CallDto {

    private String sessionId;
    private String sipCallId;
    private String callid;
    private String ani;
    private String dnis;
    private String direct;
    private String deviceid;
    private String startTime;
    private String gwMediaIp;
    private int gwMediaPort;
    private String clientMediaIp;
    private int clientMediaPort;
    private String recStatus = "idle";//recording
    private String recType = null;// ivr /station
    private String mpsLocation;
    private String mpsList;


    public void addMpsList(String mpsLocation) {
        this.mpsList=this.mpsList+mpsLocation+";";
    }
}
