package com.wilcom.recordingpush.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TCallDetail)实体类
 *
 * @author dhx
 * @since 2022-03-31 10:29:22
 */
public class TCallDetail implements Serializable {
    private static final long serialVersionUID = 454332318782800494L;
    
    private Long id;
    
    private Date beginTime;
    
    private Date endTime;
    
    private Integer callTotalDuration;
    
    private String callId;
    
    private String relatedCallId;
    
    private Integer callScenario;
    
    private Integer callType;
    
    private Integer callResult;
    
    private String localMediaIp;
    
    private String domain;
    
    private String originator;
    
    private String originatee;
    
    private String caller;
    
    private String callee;
    
    private Date ringBackTime;
    
    private Date answerTime;
    
    private Integer isAnswer;
    
    private Integer ringBackDuration;
    
    private String firstRoutePoint;
    
    private String firstQueueRoutePoint;
    
    private String firstSkillId;
    
    private String firstSkillName;
    
    private String firstAgentId;
    
    private String firstAgentName;
    
    private String firstStationId;
    
    private Date firstAgentAnswerTime;
    
    private Integer firstWaitDuration;
    
    private Integer acdBeforeDuration;
    
    private Integer queueDuration;
    
    private Integer alertTotalDuration;
    
    private Integer answerTotalDuration;
    
    private Integer consultInTotalTimes;
    
    private Integer consultInSuccTotalTimes;
    
    private Integer consultOutTotalTimes;
    
    private Integer consultOutSuccTotalTimes;
    
    private Integer holdTotalDuration;
    
    private Integer holdTotalTimes;
    
    private Integer conferenceTimes;
    
    private String abandonPoint;
    
    private Integer abandonType;
    
    private Integer hangupSide;
    
    private String gateway;
    
    private String recordServer;
    
    private String recordPath;
    
    private String satisfyCode;
    
    private Integer satisfyDuration;
    
    private Date insertTime;
    
    private Date updateTime;
    
    private Date firstSkillTime;
    
    private Date firstAgentAlterTime;
    
    private String recordFileSuffix;
    
    private Integer remoteAgent;



}

