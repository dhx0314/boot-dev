package cn.dhx.mybatisplus.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (TSkillDetail)表实体类
 *
 * @author dhx
 * @since 2022-07-16 14:08:16
 */
@SuppressWarnings("serial")
@Data
public class TSkillDetail extends Model<TSkillDetail> {
    
    private Integer id;
    
    private Date startTime;
    
    private Date endTime;
    
    private String ani;
    
    private String dnis;
    
    private String mediaType;
    
    private String callType;
    
    private String connid;
    
    private String guid;
    
    private Long interactionId;
    
    private String queueId;
    
    private Integer queueDuration;
    
    private String queueResult;
    
    private String queueScene;
    
    private Date createTime;
    
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getConnid() {
        return connid;
    }

    public void setConnid(String connid) {
        this.connid = connid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Long getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Long interactionId) {
        this.interactionId = interactionId;
    }

    public String getQueueId() {
        return queueId;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public Integer getQueueDuration() {
        return queueDuration;
    }

    public void setQueueDuration(Integer queueDuration) {
        this.queueDuration = queueDuration;
    }

    public String getQueueResult() {
        return queueResult;
    }

    public void setQueueResult(String queueResult) {
        this.queueResult = queueResult;
    }

    public String getQueueScene() {
        return queueScene;
    }

    public void setQueueScene(String queueScene) {
        this.queueScene = queueScene;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

