package cn.dhx.mybatisplus.entity;

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
 * @author dhx
 * @since 2022-07-05 09:50:03
 */
@SuppressWarnings("serial")
@TableName("filedetail")
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
    
//    private Date inserttime;
    
//    private String uui;
    
//    private String genesysuuid;



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

