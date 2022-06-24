package cn.dhx.bootdemo.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (MyDetial)实体类
 *
 * @author dhx
 * @since 2022-06-21 17:15:29
 */

@Data
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




}

