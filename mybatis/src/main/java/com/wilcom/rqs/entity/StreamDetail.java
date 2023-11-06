package com.wilcom.rqs.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (StreamDetail)实体类
 *
 * @author makejava
 * @since 2023-10-30 15:25:05
 */
public class StreamDetail implements Serializable {
    private static final long serialVersionUID = 955933631791055159L;
    
    private Long id;
    
    private String ani;
    
    private String dnis;
    
    private String callDirect;
    
    private Date startTime;
    
    private Date endTime;
    
    private Date streamStartTime;
    
    private Date streamEndTime;
    
    private String callId;
    /**
     * 0-客户;1-坐席
     */
    private String userRole;
    
    private String deviceId;
    
    private String agentId;
    
    private String deviceIp;
    
    private String contactId;
    
    private String sessionId;
    
    private Long sendPackets;
    
    private Long realSendPackets;
    
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCallDirect() {
        return callDirect;
    }

    public void setCallDirect(String callDirect) {
        this.callDirect = callDirect;
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

    public Date getStreamStartTime() {
        return streamStartTime;
    }

    public void setStreamStartTime(Date streamStartTime) {
        this.streamStartTime = streamStartTime;
    }

    public Date getStreamEndTime() {
        return streamEndTime;
    }

    public void setStreamEndTime(Date streamEndTime) {
        this.streamEndTime = streamEndTime;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getSendPackets() {
        return sendPackets;
    }

    public void setSendPackets(Long sendPackets) {
        this.sendPackets = sendPackets;
    }

    public Long getRealSendPackets() {
        return realSendPackets;
    }

    public void setRealSendPackets(Long realSendPackets) {
        this.realSendPackets = realSendPackets;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

