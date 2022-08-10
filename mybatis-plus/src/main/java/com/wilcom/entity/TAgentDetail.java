package com.wilcom.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (TAgentDetail)表实体类
 *
 * @author dhx
 * @since 2022-08-09 12:15:09
 */
@SuppressWarnings("serial")
public class TAgentDetail extends Model<TAgentDetail> {
    
    private Long id;
    
    private Date startTime;
    
    private Date endTime;
    
    private String ani;
    
    private String dnis;
    
    private String mediaType;
    
    private String callType;
    
    private String connid;
    
    private String guid;
    
    private Long interactionId;
    
    private String agentId;
    
    private String agentName;
    
    private String stationId;
    
    private String queue;
    
    private Integer dialCount;
    
    private Integer dialDuration;
    
    private Integer ringCount;
    
    private Integer ringDuration;
    
    private Integer talkCount;
    
    private Integer talkDuration;
    
    private Integer holdCount;
    
    private Integer holdDuration;
    
    private Integer acwDuration;
    
    private String callSegmentResult;
    
    private Date createTime;
    
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }
    }

