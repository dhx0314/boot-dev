package cn.dhx.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Filedetail)表实体类
 *
 * @author makejava
 * @since 2021-06-08 18:35:22
 */
@SuppressWarnings("serial")

@Data
@TableName(value = "filedetail")
public class Filedetail2 extends Model<Filedetail2> {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

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
