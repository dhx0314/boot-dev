package cn.dhx.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Filedetail)实体类
 *
 * @author dhx
 * @since 2021-09-07 18:00:00
 */

@Data
public class Filedetail implements Serializable {
    private static final long serialVersionUID = 474121856445979216L;

    private String recordtype;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startdatetime;

    private String agentfilename;

    private Integer id;

    private String fileencodingfmt;

    private Integer calllenth;

    private String callid;

    private String customfilename;

    private String calldirect;

    private String ani;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date enddatetime;

    private String agentid;

    private String deviceid;

    private String filename;

    private String dnis;


    public String getRecordtype() {
        return recordtype;
    }

    public void setRecordtype(String recordtype) {
        this.recordtype = recordtype;
    }

    public Date getStartdatetime() {
        return startdatetime;
    }

    public void setStartdatetime(Date startdatetime) {
        this.startdatetime = startdatetime;
    }

    public String getAgentfilename() {
        return agentfilename;
    }

    public void setAgentfilename(String agentfilename) {
        this.agentfilename = agentfilename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileencodingfmt() {
        return fileencodingfmt;
    }

    public void setFileencodingfmt(String fileencodingfmt) {
        this.fileencodingfmt = fileencodingfmt;
    }

    public Integer getCalllenth() {
        return calllenth;
    }

    public void setCalllenth(Integer calllenth) {
        this.calllenth = calllenth;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public String getCustomfilename() {
        return customfilename;
    }

    public void setCustomfilename(String customfilename) {
        this.customfilename = customfilename;
    }

    public String getCalldirect() {
        return calldirect;
    }

    public void setCalldirect(String calldirect) {
        this.calldirect = calldirect;
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani;
    }

    public Date getEnddatetime() {
        return enddatetime;
    }

    public void setEnddatetime(Date enddatetime) {
        this.enddatetime = enddatetime;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDnis() {
        return dnis;
    }

    public void setDnis(String dnis) {
        this.dnis = dnis;
    }

}
