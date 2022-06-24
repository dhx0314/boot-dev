package cn.dhx.bootdemo;

import cn.dhx.bootdemo.config.ConfigurationConfig;
import cn.dhx.bootdemo.dao.FiledetailDao;
import cn.dhx.bootdemo.dao.MyDetialDao;
import cn.dhx.bootdemo.entity.Filedetail;
import cn.dhx.bootdemo.entity.MyDetial;
import cn.dhx.bootdemo.entity.User2;
import cn.dhx.bootdemo.listen.DemoDataListener;
import cn.dhx.bootdemo.pojo.DemoData;
import cn.dhx.bootdemo.pojo.ExcelMode;
import cn.dhx.bootdemo.pojo.RecFile;
import cn.dhx.bootdemo.util.DateUtil;
import cn.dhx.bootdemo.util.JsonUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class BootDemoApplicationTests {


    @Autowired
    private RestTemplate template;


    @Autowired
    private ConfigurationConfig configurationConfig;

    @Autowired
    private FiledetailDao filedetailDao;

    @Autowired
    private MyDetialDao myDetialDao;


    @Test
    public void fun2() {
        List<Filedetail> filedetails = filedetailDao.queryAll();
        HashMap<String, List<Filedetail>> filedetailMap = new HashMap<>();
    }




    @Test
    public void fun1aaa() {
//        Filedetail filedetail = filedetailDao.queryById("5396138");
//        System.out.println(filedetail);
        MyDetial myDetial = new MyDetial();
        myDetial.setCallid("1111");
        MyDetial myDetial1 = new MyDetial();
        myDetial1.setCallid("222");
        ArrayList<MyDetial> myDetials = new ArrayList<>();
        myDetials.add(myDetial);
        myDetials.add(myDetial1);
        myDetialDao.insertBatch(myDetials);

//        MyDetial myDetial1 = myDetialDao.queryById(1);
//        System.out.println(myDetial1);
    }


    @Test
    public void excel() {
        String fileName = "D:\\a\\0623\\a.xls";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取100条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
//                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
                System.out.println(demoData.toString());
            }
        })).sheet().doRead();
    }

    @Test
    public void excel2() {
        String fileName = "D:\\a\\0623\\a.xls";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取100条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
//                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
//                System.out.println(demoData.toString());
                MyDetial myDetial = new MyDetial();
                BeanUtils.copyProperties(demoData, myDetial);
                String starttime = demoData.getStarttime();
                String endtime = demoData.getEndtime();
            }
        })).sheet().doRead();
    }


    @Test
    public void excel3() {
//        String fileName = "D:\\a\\0623\\a.xls";
        String fileName = "D:\\a\\0623\\202206211503.xlsx";

        EasyExcel.read(fileName, DemoData.class, new DemoDataListener(myDetialDao)).sheet().doRead();
    }


    @Test
    public void fun1awawf() {
        for (int i = 0; i < 9; i++) {
            try {
                fun1sqlold(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

//    @Test
    public void fun1sqlold(int i) throws Exception {
        System.out.println(i);

//        String path = "D:\\a\\0621\\media20220618-20\\2022-06-18\\MPS.Info.20220618-1.logs";
        String path = "D:\\a\\0621\\media20220618-20\\2022-06-19\\MPS.Info.20220619-" + i + ".logs";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        ArrayList<Filedetail> filedetails = new ArrayList<>();
        ArrayList<Filedetail> filedetails2 = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            boolean contains = line.contains("notice recFile to RCS");
            if (contains) {
//                System.out.println(line);
                int start = line.indexOf("fileName");
                int end = line.indexOf("sessionId");
                String substring = line.substring(start, end).trim();
                String substring2 = substring.substring(0, substring.length() - 1).trim();
                Map<String, String> map = mapStringToMap(substring2);
//                System.out.println(map);
                String recordType = map.get("recordType");
                Integer recLength = Integer.valueOf(map.get("recLength"));
                String deviceId = map.get("deviceId");
                String fileName = map.get("fileName");
                String agentFileName = map.get("agentFileName");
                Date startTime = new Date(Long.valueOf(map.get("startTime")));
                Date endTime = new Date(Long.valueOf(map.get("endTime")));
                Filedetail filedetail = new Filedetail();
                filedetail.setStartDateTime(startTime);
                filedetail.setEndDateTime(endTime);
                filedetail.setRecordType(recordType);
                filedetail.setDeviceId(deviceId);
                filedetail.setCallLenth(recLength);
                filedetail.setFileName(fileName);
                filedetail.setAgentFileName(agentFileName);
                filedetails.add(filedetail);
//                if (recLength >= 5) {
//                    filedetails2.add(filedetail);
//                }
            }
        }
        bufferedReader.close();

        System.out.println("filedetails "+filedetails.size());
//        System.out.println("filedetails "+filedetails2.size());
        filedetailDao.insertBatch(filedetails);
    }


    @Test
    public void fun1waer32() {
        String s = "fileName=MPS1:2022/06/20/13/20220620_131224_1103_82.wav, agentFileName=MPS1:2022/06/20/13/20220620_131224_1103_82_stereo.wav, customFileName=, filePath=/home/usr/vox/2022/06/20/13, ani=, dnis=, callDirect=null, callId=null, startTime=1655701944038, endTime=1655702026112, recLength=82, deviceId=1103, deviceIp=172.20.9.3, appName=MPS1, fileType=Active, recordType=station";
        Map<String, String> map = mapStringToMap(s);
        System.out.println(map);
    }

    public static Map<String, String> mapStringToMap(String str) {
//        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        Map<String, String> map = new HashMap<String, String>();
        for (String string : strs) {
            String[] split = string.split("=");
            if (split.length > 1) {
                String key = string.split("=")[0].trim();
                String value = string.split("=")[1].trim();
                map.put(key, value);
            }


        }
        return map;
    }


    @Test
    public void fun1sql() throws Exception {

        String path = "d:\\a\\0621\\rcs-info.20220621-0.log";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            boolean contains = line.contains("get MPS-98 recfile info");
            if (contains) {
                System.out.println(line);
                int start = line.indexOf("{");
                int end = line.indexOf("}");
                String substring = line.substring(start, end + 1);
                System.out.println(substring);
                RecFile recFile = JsonUtil.toObject(substring, RecFile.class);
                System.out.println(recFile.toString());
                Date startTime = DateUtil.dateToDate(recFile.getStartTime());
                Date endTime = DateUtil.dateToDate(recFile.getEndTime());
                Filedetail filedetail = new Filedetail();
                filedetail.setStartDateTime(startTime);
                filedetail.setEndDateTime(endTime);
                filedetail.setDeviceId(recFile.getDeviceId());
                filedetail.setRecordType(recFile.getRecordType());
                filedetail.setCallLenth(Integer.valueOf(recFile.getRecLength()));

                String fileName = recFile.getFileName();
                String customFileName = recFile.getCustomFileName();
                String agentFileName = recFile.getAgentFileName();
                filedetail.setFileName(fileName);
                filedetail.setCustomFileName(customFileName);
                filedetail.setAgentFileName(agentFileName);
                filedetailDao.insert(filedetail);

            }
        }
        bufferedReader.close();
    }


    @Test
    public void fun1() {
        String cc = configurationConfig.getTt();
        System.out.println(cc);
        HashMap<String, String> m = configurationConfig.getMaps();
        System.out.println(m);
    }


    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("----------");
        User2 user2 = new User2();
        user2.setName("aa");
        user2.setAge("10");
        user2.setAddr("mmm");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user2);
//        String url="127.0.0.1:19991/hello2";
        String url2 = "http://127.0.0.1:19991/hello2";
        ResponseEntity<String> stringResponseEntity = template.postForEntity(url2, s, String.class);
        System.out.println(stringResponseEntity.toString());
    }

}
