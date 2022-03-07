package com.wilcom.rqs.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TCallDetail)实体类
 *
 * @author dhx
 * @since 2022-02-21 16:21:56
 */
public class TCallDetail implements Serializable {
    private static final long serialVersionUID = -52296587664858412L;
    
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getCalltotalduration() {
        return calltotalduration;
    }

    public void setCalltotalduration(Integer calltotalduration) {
        this.calltotalduration = calltotalduration;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public String getRelatedcallid() {
        return relatedcallid;
    }

    public void setRelatedcallid(String relatedcallid) {
        this.relatedcallid = relatedcallid;
    }

    public Integer getCallscenario() {
        return callscenario;
    }

    public void setCallscenario(Integer callscenario) {
        this.callscenario = callscenario;
    }

    public Integer getCalltype() {
        return calltype;
    }

    public void setCalltype(Integer calltype) {
        this.calltype = calltype;
    }

    public Integer getCallresult() {
        return callresult;
    }

    public void setCallresult(Integer callresult) {
        this.callresult = callresult;
    }

    public String getLocalmediaip() {
        return localmediaip;
    }

    public void setLocalmediaip(String localmediaip) {
        this.localmediaip = localmediaip;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getOriginatee() {
        return originatee;
    }

    public void setOriginatee(String originatee) {
        this.originatee = originatee;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getCallee() {
        return callee;
    }

    public void setCallee(String callee) {
        this.callee = callee;
    }

    public Date getRingbacktime() {
        return ringbacktime;
    }

    public void setRingbacktime(Date ringbacktime) {
        this.ringbacktime = ringbacktime;
    }

    public Date getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Date answertime) {
        this.answertime = answertime;
    }

    public Integer getIsanswer() {
        return isanswer;
    }

    public void setIsanswer(Integer isanswer) {
        this.isanswer = isanswer;
    }

    public Integer getRingbackduration() {
        return ringbackduration;
    }

    public void setRingbackduration(Integer ringbackduration) {
        this.ringbackduration = ringbackduration;
    }

    public String getFirstroutepoint() {
        return firstroutepoint;
    }

    public void setFirstroutepoint(String firstroutepoint) {
        this.firstroutepoint = firstroutepoint;
    }

    public String getFirstqueueroutepoint() {
        return firstqueueroutepoint;
    }

    public void setFirstqueueroutepoint(String firstqueueroutepoint) {
        this.firstqueueroutepoint = firstqueueroutepoint;
    }

    public String getFirstskillid() {
        return firstskillid;
    }

    public void setFirstskillid(String firstskillid) {
        this.firstskillid = firstskillid;
    }

    public String getFirstskillname() {
        return firstskillname;
    }

    public void setFirstskillname(String firstskillname) {
        this.firstskillname = firstskillname;
    }

    public String getFirstagentid() {
        return firstagentid;
    }

    public void setFirstagentid(String firstagentid) {
        this.firstagentid = firstagentid;
    }

    public String getFirstagentname() {
        return firstagentname;
    }

    public void setFirstagentname(String firstagentname) {
        this.firstagentname = firstagentname;
    }

    public String getFirststationid() {
        return firststationid;
    }

    public void setFirststationid(String firststationid) {
        this.firststationid = firststationid;
    }

    public Date getFirstagentanswertime() {
        return firstagentanswertime;
    }

    public void setFirstagentanswertime(Date firstagentanswertime) {
        this.firstagentanswertime = firstagentanswertime;
    }

    public Integer getFirstwaitduration() {
        return firstwaitduration;
    }

    public void setFirstwaitduration(Integer firstwaitduration) {
        this.firstwaitduration = firstwaitduration;
    }

    public Integer getAcdbeforeduration() {
        return acdbeforeduration;
    }

    public void setAcdbeforeduration(Integer acdbeforeduration) {
        this.acdbeforeduration = acdbeforeduration;
    }

    public Integer getQueueduration() {
        return queueduration;
    }

    public void setQueueduration(Integer queueduration) {
        this.queueduration = queueduration;
    }

    public Integer getAlerttotalduration() {
        return alerttotalduration;
    }

    public void setAlerttotalduration(Integer alerttotalduration) {
        this.alerttotalduration = alerttotalduration;
    }

    public Integer getAnswertotalduration() {
        return answertotalduration;
    }

    public void setAnswertotalduration(Integer answertotalduration) {
        this.answertotalduration = answertotalduration;
    }

    public Integer getConsultintotaltimes() {
        return consultintotaltimes;
    }

    public void setConsultintotaltimes(Integer consultintotaltimes) {
        this.consultintotaltimes = consultintotaltimes;
    }

    public Integer getConsultinsucctotaltimes() {
        return consultinsucctotaltimes;
    }

    public void setConsultinsucctotaltimes(Integer consultinsucctotaltimes) {
        this.consultinsucctotaltimes = consultinsucctotaltimes;
    }

    public Integer getConsultouttotaltimes() {
        return consultouttotaltimes;
    }

    public void setConsultouttotaltimes(Integer consultouttotaltimes) {
        this.consultouttotaltimes = consultouttotaltimes;
    }

    public Integer getConsultoutsucctotaltimes() {
        return consultoutsucctotaltimes;
    }

    public void setConsultoutsucctotaltimes(Integer consultoutsucctotaltimes) {
        this.consultoutsucctotaltimes = consultoutsucctotaltimes;
    }

    public Integer getHoldtotalduration() {
        return holdtotalduration;
    }

    public void setHoldtotalduration(Integer holdtotalduration) {
        this.holdtotalduration = holdtotalduration;
    }

    public Integer getHoldtotaltimes() {
        return holdtotaltimes;
    }

    public void setHoldtotaltimes(Integer holdtotaltimes) {
        this.holdtotaltimes = holdtotaltimes;
    }

    public Integer getConferencetimes() {
        return conferencetimes;
    }

    public void setConferencetimes(Integer conferencetimes) {
        this.conferencetimes = conferencetimes;
    }

    public String getAbandonpoint() {
        return abandonpoint;
    }

    public void setAbandonpoint(String abandonpoint) {
        this.abandonpoint = abandonpoint;
    }

    public Integer getAbandontype() {
        return abandontype;
    }

    public void setAbandontype(Integer abandontype) {
        this.abandontype = abandontype;
    }

    public Integer getHangupside() {
        return hangupside;
    }

    public void setHangupside(Integer hangupside) {
        this.hangupside = hangupside;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getRecordserver() {
        return recordserver;
    }

    public void setRecordserver(String recordserver) {
        this.recordserver = recordserver;
    }

    public String getRecordpath() {
        return recordpath;
    }

    public void setRecordpath(String recordpath) {
        this.recordpath = recordpath;
    }

    public String getSatisfycode() {
        return satisfycode;
    }

    public void setSatisfycode(String satisfycode) {
        this.satisfycode = satisfycode;
    }

    public Integer getSatisfyduration() {
        return satisfyduration;
    }

    public void setSatisfyduration(Integer satisfyduration) {
        this.satisfyduration = satisfyduration;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getFirstskilltime() {
        return firstskilltime;
    }

    public void setFirstskilltime(Date firstskilltime) {
        this.firstskilltime = firstskilltime;
    }

    public Date getFirstagentaltertime() {
        return firstagentaltertime;
    }

    public void setFirstagentaltertime(Date firstagentaltertime) {
        this.firstagentaltertime = firstagentaltertime;
    }

    public String getRecordfilesuffix() {
        return recordfilesuffix;
    }

    public void setRecordfilesuffix(String recordfilesuffix) {
        this.recordfilesuffix = recordfilesuffix;
    }

    public Integer getRemoteagent() {
        return remoteagent;
    }

    public void setRemoteagent(Integer remoteagent) {
        this.remoteagent = remoteagent;
    }

}

