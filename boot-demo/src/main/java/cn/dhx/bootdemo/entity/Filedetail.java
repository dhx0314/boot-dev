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

    private String fileName;

    private String agentFileName;

    private String customFileName;

    private String deviceId;

    private String agentId;

    private Date startDateTime;

    private Date endDateTime;

    private String callid;

    private Integer callLenth;

    private String RecordType;

    private String fileEncodingFmt;


}

