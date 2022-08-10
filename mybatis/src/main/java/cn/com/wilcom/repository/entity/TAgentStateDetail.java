package cn.com.wilcom.repository.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TAgentStateDetail)实体类
 *
 * @author dhx
 * @since 2022-07-20 10:41:07
 */
public class TAgentStateDetail implements Serializable {
    private static final long serialVersionUID = -89992881192819394L;
    
    private Integer id;
    
    private Long state_id;
    
    private String agent_id;
    
    private String agent_name;
    
    private Date start_time;
    
    private Date end_time;
    
    private String media_type;
    
    private Date reason_start_time;
    
    private Date reason_end_time;
    
    private String state;
    
    private String reason;
    
    private Integer duration;
    
    private Integer head_clip_duration;
    
    private Integer trail_clip_duration;
    
    private Date create_time;
    
    private Date update_time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
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

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Date getReasonStartTime() {
        return reasonStartTime;
    }

    public void setReasonStartTime(Date reasonStartTime) {
        this.reasonStartTime = reasonStartTime;
    }

    public Date getReasonEndTime() {
        return reasonEndTime;
    }

    public void setReasonEndTime(Date reasonEndTime) {
        this.reasonEndTime = reasonEndTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getHeadClipDuration() {
        return headClipDuration;
    }

    public void setHeadClipDuration(Integer headClipDuration) {
        this.headClipDuration = headClipDuration;
    }

    public Integer getTrailClipDuration() {
        return trailClipDuration;
    }

    public void setTrailClipDuration(Integer trailClipDuration) {
        this.trailClipDuration = trailClipDuration;
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

