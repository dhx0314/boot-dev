package com.telecom.receiver.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Filedetail)表实体类
 *
 * @author makejava
 * @since 2023-06-01 14:55:55
 */
@SuppressWarnings("serial")
@Data
@TableName("filedetail")
public class Filedetail extends Model<Filedetail> {

    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String ani;
    
    private String dnis;
    
    private String calldirect;
    
    private String fileid;
    
    private String filename;
    
    private String agentfilename;
    
    private String customfilename;
    
    private String fileinfo;
    
    private String deviceid;
    
    private String agentid;
    
    private Date startdatetime;
    
    private Date enddatetime;
    
    private String callid;
    
    private String contactid;
    
    private Integer calllenth;
    
    private String recordtype;
    
    private String servername;
    
    private String fileencodingfmt;
    
    private String separablefileencodingfmt;
    
    private Date createTime;
    
    private String uui;
    
    private String operatetype;
    
    private String mpsip;
    
    private String sipcallid;


    }

