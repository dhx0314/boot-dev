package cn.dhx.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TCallDetail)实体类
 *
 * @author dhx
 * @since 2022-07-20 11:28:02
 */
public class TCallDetail implements Serializable {
    private static final long serialVersionUID = 197198475359600431L;
    
    private Integer id;
    
    private Date start_time;
    
    private Date end_time;
    
    private String ani;
    
    private String dnis;
    
    private String media_type;
    
    private String call_type;
    
    private String connid;
    
    private String guid;
    
    private Long interaction_id;
    
    private String first_agent_rp;
    
    private String first_queue;
    
    private Date first_queue_start_time;
    
    private String first_agent;
    
    private String first_station;
    
    private String first_agent_queue;
    
    private Integer first_agent_asw_duration;
    
    private Integer abandon_duration;
    
    private Integer mediation_duration;
    
    private Integer queue_duration;
    
    private Integer call_duration;
    
    private Integer talk_count;
    
    private Integer talk_duration;
    
    private Integer ring_duration;
    
    private Integer acw_count;
    
    private Integer acw_duration;
    
    private String call_result;
    
    private Integer hold_count;
    
    private Integer hold_duration;
    
    private String stop_party;
    
    private Integer cons_init_count;
    
    private Integer transfer_count;
    
    private Date create_time;
    
    private Date update_time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani;
    }

    public String getDnis() {
        return dnis;
    }

    public void setDnis(String dnis) {
        this.dnis = dnis;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getConnid() {
        return connid;
    }

    public void setConnid(String connid) {
        this.connid = connid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Long getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Long interactionId) {
        this.interactionId = interactionId;
    }

    public String getFirstAgentRp() {
        return firstAgentRp;
    }

    public void setFirstAgentRp(String firstAgentRp) {
        this.firstAgentRp = firstAgentRp;
    }

    public String getFirstQueue() {
        return firstQueue;
    }

    public void setFirstQueue(String firstQueue) {
        this.firstQueue = firstQueue;
    }

    public Date getFirstQueueStartTime() {
        return firstQueueStartTime;
    }

    public void setFirstQueueStartTime(Date firstQueueStartTime) {
        this.firstQueueStartTime = firstQueueStartTime;
    }

    public String getFirstAgent() {
        return firstAgent;
    }

    public void setFirstAgent(String firstAgent) {
        this.firstAgent = firstAgent;
    }

    public String getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public String getFirstAgentQueue() {
        return firstAgentQueue;
    }

    public void setFirstAgentQueue(String firstAgentQueue) {
        this.firstAgentQueue = firstAgentQueue;
    }

    public Integer getFirstAgentAswDuration() {
        return firstAgentAswDuration;
    }

    public void setFirstAgentAswDuration(Integer firstAgentAswDuration) {
        this.firstAgentAswDuration = firstAgentAswDuration;
    }

    public Integer getAbandonDuration() {
        return abandonDuration;
    }

    public void setAbandonDuration(Integer abandonDuration) {
        this.abandonDuration = abandonDuration;
    }

    public Integer getMediationDuration() {
        return mediationDuration;
    }

    public void setMediationDuration(Integer mediationDuration) {
        this.mediationDuration = mediationDuration;
    }

    public Integer getQueueDuration() {
        return queueDuration;
    }

    public void setQueueDuration(Integer queueDuration) {
        this.queueDuration = queueDuration;
    }

    public Integer getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Integer callDuration) {
        this.callDuration = callDuration;
    }

    public Integer getTalkCount() {
        return talkCount;
    }

    public void setTalkCount(Integer talkCount) {
        this.talkCount = talkCount;
    }

    public Integer getTalkDuration() {
        return talkDuration;
    }

    public void setTalkDuration(Integer talkDuration) {
        this.talkDuration = talkDuration;
    }

    public Integer getRingDuration() {
        return ringDuration;
    }

    public void setRingDuration(Integer ringDuration) {
        this.ringDuration = ringDuration;
    }

    public Integer getAcwCount() {
        return acwCount;
    }

    public void setAcwCount(Integer acwCount) {
        this.acwCount = acwCount;
    }

    public Integer getAcwDuration() {
        return acwDuration;
    }

    public void setAcwDuration(Integer acwDuration) {
        this.acwDuration = acwDuration;
    }

    public String getCallResult() {
        return callResult;
    }

    public void setCallResult(String callResult) {
        this.callResult = callResult;
    }

    public Integer getHoldCount() {
        return holdCount;
    }

    public void setHoldCount(Integer holdCount) {
        this.holdCount = holdCount;
    }

    public Integer getHoldDuration() {
        return holdDuration;
    }

    public void setHoldDuration(Integer holdDuration) {
        this.holdDuration = holdDuration;
    }

    public String getStopParty() {
        return stopParty;
    }

    public void setStopParty(String stopParty) {
        this.stopParty = stopParty;
    }

    public Integer getConsInitCount() {
        return consInitCount;
    }

    public void setConsInitCount(Integer consInitCount) {
        this.consInitCount = consInitCount;
    }

    public Integer getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(Integer transferCount) {
        this.transferCount = transferCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

