package cn.dhx.bootdemo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (MyDetial)实体类
 *
 * @author dhx
 * @since 2022-06-21 17:15:29
 */
public class MyDetial implements Serializable {
    private static final long serialVersionUID = 629543100098441976L;
    
    private Integer id;
    
    private String callid;
    
    private String inboundno;
    
    private String custphone;
    
    private Date starttime;
    
    private Date endtime;
    
    private String agentid;
    
    private String extension;
    
    private String outboundno;
    
    private String calltype;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public String getInboundno() {
        return inboundno;
    }

    public void setInboundno(String inboundno) {
        this.inboundno = inboundno;
    }

    public String getCustphone() {
        return custphone;
    }

    public void setCustphone(String custphone) {
        this.custphone = custphone;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getOutboundno() {
        return outboundno;
    }

    public void setOutboundno(String outboundno) {
        this.outboundno = outboundno;
    }

    public String getCalltype() {
        return calltype;
    }

    public void setCalltype(String calltype) {
        this.calltype = calltype;
    }

}

