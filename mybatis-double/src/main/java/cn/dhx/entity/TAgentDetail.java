package cn.dhx.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TAgentDetail implements Serializable {
    private static final long serialVersionUID = -13646640530419642L;
    
    private Long id;
    
    private String agentid;
    
    private String agentname;
    
    private String stationid;
    
    private String skillid;
    
    private String skillname;
    
    private Date begintime;
    
    private Date endtime;
    
    private Integer callduration;
    
    private String callid;
    
    private String relatedcallid;
    
    private Integer callscenario;
    
    private Integer calltype;
    
    private Integer callmode;
    
    private Integer callresult;
    
    private String localmediaip;
    
    private String domain;
    
    private String originator;
    
    private String originatee;
    
    private String caller;
    
    private String callee;
    
    private Date alerttime;
    
    private Date answertime;
    
    private Integer alertduration;
    
    private Integer answerduration;
    
    private Integer consultintimes;
    
    private Integer consultinsucctimes;
    
    private Integer consultouttimes;
    
    private Integer consultoutsucctimes;
    
    private Integer holdduration;
    
    private Integer holdtimes;
    
    private Integer acwduration;
    
    private String transfrom;
    
    private String transto;
    
    private Integer transoutflag;
    
    private String satisfycode;
    
    private Integer satisfyduration;
    
    private String gateway;
    
    private Date inserttime;
    
    private Date updatetime;
    
    private Integer remoteagent;

}

