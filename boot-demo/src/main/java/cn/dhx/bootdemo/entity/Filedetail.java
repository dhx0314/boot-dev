package cn.dhx.bootdemo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Filedetail)实体类
 *
 * @author dhx
 * @since 2022-06-21 10:00:42
 */
@Data
public class Filedetail implements Serializable {
    private static final long serialVersionUID = 692503886936755852L;
    
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getCallDirect() {
        return callDirect;
    }

    public void setCallDirect(String callDirect) {
        this.callDirect = callDirect;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAgentFileName() {
        return agentFileName;
    }

    public void setAgentFileName(String agentFileName) {
        this.agentFileName = agentFileName;
    }

    public String getCustomFileName() {
        return customFileName;
    }

    public void setCustomFileName(String customFileName) {
        this.customFileName = customFileName;
    }

    public String getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(String fileInfo) {
        this.fileInfo = fileInfo;
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

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public Integer getCallLenth() {
        return callLenth;
    }

    public void setCallLenth(Integer callLenth) {
        this.callLenth = callLenth;
    }

    public String getRecordType() {
        return RecordType;
    }

    public void setRecordType(String recordType) {
        RecordType = recordType;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getFileEncodingFmt() {
        return fileEncodingFmt;
    }

    public void setFileEncodingFmt(String fileEncodingFmt) {
        this.fileEncodingFmt = fileEncodingFmt;
    }

    public String getSeparableFileEncodingFmt() {
        return separableFileEncodingFmt;
    }

    public void setSeparableFileEncodingFmt(String separableFileEncodingFmt) {
        this.separableFileEncodingFmt = separableFileEncodingFmt;
    }
}

