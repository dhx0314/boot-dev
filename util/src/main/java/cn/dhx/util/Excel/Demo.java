package cn.dhx.util.Excel;

import cn.dhx.util.Excel.entity.ResultInfo;
import cn.dhx.util.Excel.util.ExcelUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws IOException {

        List<ResultInfo> listResultInfo = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setUnit("单位" + j);
            resultInfo.setLoanId("贷款编号" + j);
            resultInfo.setStateNow("当前状态" + j);
            resultInfo.setDate(new Date());
            listResultInfo.add(resultInfo);
        }
        File file = new File("a2.xlsx");

        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.writeExcel(file, listResultInfo);
    }

}
