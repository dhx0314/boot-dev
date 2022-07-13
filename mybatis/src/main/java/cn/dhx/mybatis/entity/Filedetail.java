package cn.dhx.mybatis.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Filedetail)表实体类
 *
 * @author dhx
 * @since 2022-07-13 23:05:50
 */
@SuppressWarnings("serial")
@Data
public class Filedetail extends Model<Filedetail> {

    @TableId(type = IdType.AUTO)
    private String id;
    
    private String ani;
    
    private String dnis;
    
    private String calldirect;
    
    private String filename;
    
    private String agentfilename;
    
    private String customfilename;
    
    private String deviceid;
    
    private String agentid;
    
    private Date startdatetime;
    
    private Date enddatetime;
    
    private String callid;
    
    private Integer calllenth;
    
    private String recordtype;
    
    private String fileencodingfmt;
    
    private String fileid;
    
    private String fileinfo;
    
    private String contactid;
    
    private String servername;
    
    private String separablefileencodingfmt;
    
    private Date inserttime;
    
    private String uui;
    
    private String genesysuuid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getCalldirect() {
        return calldirect;
    }

    public void setCalldirect(String calldirect) {
        this.calldirect = calldirect;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getAgentfilename() {
        return agentfilename;
    }

    public void setAgentfilename(String agentfilename) {
        this.agentfilename = agentfilename;
    }

    public String getCustomfilename() {
        return customfilename;
    }

    public void setCustomfilename(String customfilename) {
        this.customfilename = customfilename;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public Date getStartdatetime() {
        return startdatetime;
    }

    public void setStartdatetime(Date startdatetime) {
        this.startdatetime = startdatetime;
    }

    public Date getEnddatetime() {
        return enddatetime;
    }

    public void setEnddatetime(Date enddatetime) {
        this.enddatetime = enddatetime;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public Integer getCalllenth() {
        return calllenth;
    }

    public void setCalllenth(Integer calllenth) {
        this.calllenth = calllenth;
    }

    public String getRecordtype() {
        return recordtype;
    }

    public void setRecordtype(String recordtype) {
        this.recordtype = recordtype;
    }

    public String getFileencodingfmt() {
        return fileencodingfmt;
    }

    public void setFileencodingfmt(String fileencodingfmt) {
        this.fileencodingfmt = fileencodingfmt;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public String getFileinfo() {
        return fileinfo;
    }

    public void setFileinfo(String fileinfo) {
        this.fileinfo = fileinfo;
    }

    public String getContactid() {
        return contactid;
    }

    public void setContactid(String contactid) {
        this.contactid = contactid;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public String getSeparablefileencodingfmt() {
        return separablefileencodingfmt;
    }

    public void setSeparablefileencodingfmt(String separablefileencodingfmt) {
        this.separablefileencodingfmt = separablefileencodingfmt;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public String getUui() {
        return uui;
    }

    public void setUui(String uui) {
        this.uui = uui;
    }

    public String getGenesysuuid() {
        return genesysuuid;
    }

    public void setGenesysuuid(String genesysuuid) {
        this.genesysuuid = genesysuuid;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }

