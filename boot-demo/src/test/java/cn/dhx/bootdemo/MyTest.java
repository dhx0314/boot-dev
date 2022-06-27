package cn.dhx.bootdemo;


import cn.dhx.bootdemo.dao.FiledetailDao;
import cn.dhx.bootdemo.dao.MyDetialDao;
import cn.dhx.bootdemo.entity.Filedetail;
import cn.dhx.bootdemo.entity.MyDetial;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {


    @Autowired
    private FiledetailDao filedetailDao;

    @Autowired
    private MyDetialDao myDetialDao;

    @Test
    public void fun1() {
        List<MyDetial> myDetials = myDetialDao.queryAll();
        HashMap<String, ArrayList<MyDetial>> myDetialHashMap = new HashMap<>();


        ArrayList<Filedetail> insert = new ArrayList<>();
        for (MyDetial myDetial : myDetials) {
            String extension = myDetial.getExtension();
            ArrayList<MyDetial> myDetials1 = myDetialHashMap.get(extension);
            if (null == myDetials1) {
                myDetials1 = new ArrayList<>();
                myDetials1.add(myDetial);
                myDetialHashMap.put(extension, myDetials1);
            } else {
                myDetials1.add(myDetial);
            }
        }

        List<Filedetail> filedetails = filedetailDao.queryAll();
        System.out.println(filedetails.size());
        HashMap<String, ArrayList<Filedetail>> filedetailHashMap = new HashMap<>();

        for (Filedetail filedetail : filedetails) {
            String deviceId = filedetail.getDeviceId();
            ArrayList<Filedetail> filedetails1 = filedetailHashMap.get(deviceId);
            if (null == filedetails1 || filedetails1.size() == 0) {
                filedetails1 = new ArrayList<>();
                filedetails1.add(filedetail);
                filedetailHashMap.put(deviceId, filedetails1);
            } else {
                filedetails1.add(filedetail);
            }
        }

        for (Map.Entry<String, ArrayList<Filedetail>> entry : filedetailHashMap.entrySet()) {
            String deviceId = entry.getKey();
            ArrayList<Filedetail> filedetails1 = entry.getValue();
            ArrayList<MyDetial> myDetials1 = myDetialHashMap.get(deviceId);
            for (Filedetail filedetail : filedetails1) {

                Date startDateTime = filedetail.getStartDateTime();
                Date endDateTime = filedetail.getEndDateTime();
                for (MyDetial myDetial : myDetials1) {
                    Date starttime = myDetial.getStarttime();
                    Date endtime = myDetial.getEndtime();
                    if (endtime == null) {
                        System.out.println(myDetial);
                        continue;
                    }
                    boolean flag = false;
                    if (starttime.getTime() <= startDateTime.getTime() && startDateTime.getTime() <= endtime.getTime()) {
                        flag = true;
                    }
                    if (starttime.getTime() <= endDateTime.getTime() && endDateTime.getTime() <= endtime.getTime()) {
                        flag = true;
                    }
                    if (flag) {
                        Filedetail filedetail1 = new Filedetail();
                        String agentid = myDetial.getAgentid();
                        String extension = myDetial.getExtension();
                        String calltype = myDetial.getCalltype();
                        String custphone = myDetial.getCustphone();
                        String inboundno = myDetial.getInboundno();
                        BeanUtils.copyProperties(filedetail,filedetail1);
                        filedetail1.setAgentId(agentid);
                        filedetail1.setCallid(myDetial.getCallid());
                        if ("3".equals(calltype)) {
                            filedetail1.setAni(extension);
                            filedetail1.setDnis(custphone);
                            filedetail1.setCallDirect("out");
                        }else {
                            filedetail1.setAni(inboundno);
                            filedetail1.setDnis(extension);
                            filedetail1.setCallDirect("in");
                        }
                        insert.add(filedetail1);
                        break;
                    }
                }
            }
        }

        System.out.println(insert.size());
        int i = filedetailDao.insertBatch(insert);
        System.out.println(i);
    }
















    @Test
    public void fun1sqlold2() throws Exception {
//        System.out.println(i);

        String path = "D:\\a\\0621\\media20220618-20\\2022-06-18\\MPS.Info.20220618-0.logs";
//        String path = "D:\\a\\0621\\media20220618-20\\2022-06-19\\MPS.Info.20220619-" + i + ".logs";
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
}
