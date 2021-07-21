package cn.dhx.util.Excel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class ResultInfo extends BaseRowModel {

    @ExcelProperty(value = "单位（万卢比）", index = 1)
    private String unit;

    @ExcelProperty(value = "贷款编号", index = 2)
    private String loanId;

    @ExcelProperty(value = "当前状态", index = 3)
    private String stateNow;

    @ExcelProperty(value = "date", index = 4)
    private Date date;



}
