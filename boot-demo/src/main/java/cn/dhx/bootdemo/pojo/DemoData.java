package cn.dhx.bootdemo.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class DemoData {

    @ExcelProperty(index = 3)
    private String callid;
    @ExcelProperty(index = 4)
    private String inboundno;
    @ExcelProperty(index = 49)
    private String custphone;
    @ExcelProperty(index = 6)
    private String starttime;
    @ExcelProperty(index = 7)
    private String endtime;

    @ExcelProperty(index = 20)
    private String agentid;
    @ExcelProperty(index = 24)
    private String extension;
    @ExcelProperty(index = 23)
    private String outboundno;
    @ExcelProperty(index = 34)
    private String calltype;

}
