package com.wilcom.rqs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TAgentDetail)实体类
 *
 * @author dhx
 * @since 2022-02-21 16:24:07
 */
public class TAgentDetail implements Serializable {
    private static final long serialVersionUID = -49261268111599742L;
    
    private Long id;
    
    private String agentId;
    
    private String agentName;
    
    private String stationId;
    
    private String skillId;
    
    private String skillName;
    
    private Date beginTime;
    
    private Date endTime;
    
    private Integer callDuration;
    
    private String callId;
    
    private String relatedCallId;
    
    private Integer callScenario;
    
    private Integer callType;
    
    private Integer callMode;
    
    private Integer callResult;
    
    private String localMediaIp;
    
    private String domain;
    
    private String originator;
    
    private String originatee;
    
    private String caller;
    
    private String callee;
    
    private Date alertTime;
    
    private Date answerTime;
    
    private Integer alertDuration;
    
    private Integer answerDuration;
    
    private Integer consultInTimes;
    
    private Integer consultInSuccTimes;
    
    private Integer consultOutTimes;
    
    private Integer consultOutSuccTimes;
    
    private Integer holdDuration;
    
    private Integer holdTimes;
    
    private Integer acwDuration;
    
    private String transFrom;
    
    private String transTo;
    
    private integer transOutFlag;
    
    private String satisfyCode;
    
    private Integer satisfyDuration;
    
    private String gateway;
    
    private Date insertTime;
    
    private Date updateTime;
    
    private Integer remoteAgent;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid;
    }

    public String getSkillid() {
        return skillid;
    }

    public void setSkillid(String skillid) {
        this.skillid = skillid;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
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

    public Integer getCallduration() {
        return callduration;
    }

    public void setCallduration(Integer callduration) {
        this.callduration = callduration;
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

    public Integer getCallmode() {
        return callmode;
    }

    public void setCallmode(Integer callmode) {
        this.callmode = callmode;
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

    public Date getAlerttime() {
        return alerttime;
    }

    public void setAlerttime(Date alerttime) {
        this.alerttime = alerttime;
    }

    public Date getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Date answertime) {
        this.answertime = answertime;
    }

    public Integer getAlertduration() {
        return alertduration;
    }

    public void setAlertduration(Integer alertduration) {
        this.alertduration = alertduration;
    }

    public Integer getAnswerduration() {
        return answerduration;
    }

    public void setAnswerduration(Integer answerduration) {
        this.answerduration = answerduration;
    }

    public Integer getConsultintimes() {
        return consultintimes;
    }

    public void setConsultintimes(Integer consultintimes) {
        this.consultintimes = consultintimes;
    }

    public Integer getConsultinsucctimes() {
        return consultinsucctimes;
    }

    public void setConsultinsucctimes(Integer consultinsucctimes) {
        this.consultinsucctimes = consultinsucctimes;
    }

    public Integer getConsultouttimes() {
        return consultouttimes;
    }

    public void setConsultouttimes(Integer consultouttimes) {
        this.consultouttimes = consultouttimes;
    }

    public Integer getConsultoutsucctimes() {
        return consultoutsucctimes;
    }

    public void setConsultoutsucctimes(Integer consultoutsucctimes) {
        this.consultoutsucctimes = consultoutsucctimes;
    }

    public Integer getHoldduration() {
        return holdduration;
    }

    public void setHoldduration(Integer holdduration) {
        this.holdduration = holdduration;
    }

    public Integer getHoldtimes() {
        return holdtimes;
    }

    public void setHoldtimes(Integer holdtimes) {
        this.holdtimes = holdtimes;
    }

    public Integer getAcwduration() {
        return acwduration;
    }

    public void setAcwduration(Integer acwduration) {
        this.acwduration = acwduration;
    }

    public String getTransfrom() {
        return transfrom;
    }

    public void setTransfrom(String transfrom) {
        this.transfrom = transfrom;
    }

    public String getTransto() {
        return transto;
    }

    public void setTransto(String transto) {
        this.transto = transto;
    }

    public integer getTransoutflag() {
        return transoutflag;
    }

    public void setTransoutflag(integer transoutflag) {
        this.transoutflag = transoutflag;
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

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
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

    public Integer getRemoteagent() {
        return remoteagent;
    }

    public void setRemoteagent(Integer remoteagent) {
        this.remoteagent = remoteagent;
    }

}

