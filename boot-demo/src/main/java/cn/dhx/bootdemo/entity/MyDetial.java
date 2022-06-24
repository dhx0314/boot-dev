package cn.dhx.bootdemo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (MyDetial)实体类
 *
 * @author dhx
 * @since 2022-06-21 17:15:29
 */

@Data
public class MyDetial  implements Serializable {
    private static final long serialVersionUID = 629543100098441976L;
    
    private Integer id;

    @ExcelProperty(index = 3)
    private String callid;
    @ExcelProperty(index = 4)
    private String inboundno;
    @ExcelProperty(index = 49)
    private String custphone;
    @ExcelProperty(index = 6)
    private Date starttime;
    @ExcelProperty(index = 7)
    private Date endtime;

    @ExcelProperty(index = 20)
    private String agentid;
    @ExcelProperty(index = 24)
    private String extension;
    @ExcelProperty(index = 23)
    private String outboundno;
    @ExcelProperty(index = 34)
    private String calltype;




}

