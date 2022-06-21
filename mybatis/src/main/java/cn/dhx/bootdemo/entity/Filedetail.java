package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Filedetail)实体类
 *
 * @author dhx
 * @since 2022-06-21 13:44:10
 */
public class Filedetail implements Serializable {
    private static final long serialVersionUID = 571345111864366213L;
    
    private String id;
    
    private String ani;
    
    private String dnis;
    
    private String callDirect;
    
    private String fileId;
    
    private String fileName;
    
    private String agentFileName;
    
    private String customFileName;
    
    private String fileInfo;
    
    private String deviceId;
    
    private String agentId;
    
    private Date startDateTime;
    
    private Date endDateTime;
    
    private String callid;
    
    private String contactId;
    
    private Integer callLenth;
    
    private String RecordType;
    
    private String serverName;
    
    private String fileEncodingFmt;
    
    private String separableFileEncodingFmt;


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

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
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

    public String getFileinfo() {
        return fileinfo;
    }

    public void setFileinfo(String fileinfo) {
        this.fileinfo = fileinfo;
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

    public String getContactid() {
        return contactid;
    }

    public void setContactid(String contactid) {
        this.contactid = contactid;
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

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public String getFileencodingfmt() {
        return fileencodingfmt;
    }

    public void setFileencodingfmt(String fileencodingfmt) {
        this.fileencodingfmt = fileencodingfmt;
    }

    public String getSeparablefileencodingfmt() {
        return separablefileencodingfmt;
    }

    public void setSeparablefileencodingfmt(String separablefileencodingfmt) {
        this.separablefileencodingfmt = separablefileencodingfmt;
    }

}

