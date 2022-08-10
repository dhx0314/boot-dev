package cn.com.wilcom.repository.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TAgentDetail)实体类
 *
 * @author dhx
 * @since 2022-07-20 10:36:48
 */
public class TAgentDetail implements Serializable {
    private static final long serialVersionUID = 273958557002995878L;
    
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
    
    private String agent_id;
    
    private String agent_name;
    
    private String station_id;
    
    private String queue;
    
    private Integer dial_count;
    
    private Integer dial_duration;
    
    private Integer ring_count;
    
    private Integer ring_duration;
    
    private Integer talk_count;
    
    private Integer talk_duration;
    
    private Integer hold_count;
    
    private Integer hold_duration;
    
    private Integer acw_duration;
    
    private String call_segment_result;
    
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

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public Integer getDialCount() {
        return dialCount;
    }

    public void setDialCount(Integer dialCount) {
        this.dialCount = dialCount;
    }

    public Integer getDialDuration() {
        return dialDuration;
    }

    public void setDialDuration(Integer dialDuration) {
        this.dialDuration = dialDuration;
    }

    public Integer getRingCount() {
        return ringCount;
    }

    public void setRingCount(Integer ringCount) {
        this.ringCount = ringCount;
    }

    public Integer getRingDuration() {
        return ringDuration;
    }

    public void setRingDuration(Integer ringDuration) {
        this.ringDuration = ringDuration;
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

    public Integer getAcwDuration() {
        return acwDuration;
    }

    public void setAcwDuration(Integer acwDuration) {
        this.acwDuration = acwDuration;
    }

    public String getCallSegmentResult() {
        return callSegmentResult;
    }

    public void setCallSegmentResult(String callSegmentResult) {
        this.callSegmentResult = callSegmentResult;
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

