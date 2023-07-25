package cn.dhx;

import cn.dhx.boot.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author daihongxin
 * @create 2023/6/28 15:06
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class JsonTest {


    @Test
    public void jsonArray() throws JsonProcessingException {
//[
//    {
//        "id": 1,
//        "qty": 20,
//        "type": "测试",
//        "time": "2022-08-02"
//    },
//    {
//        "id": 2,
//        "qty": 10,
//        "type": "测试",
//        "time": "2022-08-02"
//    },
//    {
//        "id": 3,
//        "qty": 17,
//        "type": "测试",
//        "time": "2022-08-02"
//    }
//]

        String jsonStr = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"qty\": 20,\n" +
                "        \"type\": \"测试\",\n" +
                "        \"time\": \"2022-08-02\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"qty\": 10,\n" +
                "        \"type\": \"测试\",\n" +
                "        \"time\": \"2022-08-02\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"qty\": 17,\n" +
                "        \"type\": \"测试\",\n" +
                "        \"time\": \"2022-08-02\"\n" +
                "    }\n" +
                "]";
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonDto> jsonDtos = objectMapper.readValue(jsonStr, new TypeReference<List<JsonDto>>() {
        });
        for (JsonDto jsonDto : jsonDtos) {
            System.out.println(jsonDto.toString());
        }
    }


    @Test
    public void jsonMap() throws JsonProcessingException {
//{
//    "list": [
//        {
//            "id": 1,
//            "qty": 20,
//            "type": "测试",
//            "time": "2022-08-02"
//        },
//        {
//            "id": 2,
//            "qty": 10,
//            "type": "测试",
//            "time": "2022-08-02"
//        },
//        {
//            "id": 3,
//            "qty": 17,
//            "type": "测试",
//            "time": "2022-08-02"
//        }
//    ]
//}

        String jsonStr = "{\n" +
                "    \"list\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"qty\": 20,\n" +
                "            \"type\": \"测试\",\n" +
                "            \"time\": \"2022-08-02\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"qty\": 10,\n" +
                "            \"type\": \"测试\",\n" +
                "            \"time\": \"2022-08-02\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"qty\": 17,\n" +
                "            \"type\": \"测试\",\n" +
                "            \"time\": \"2022-08-02\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<JsonDto>> stringListMap = objectMapper.readValue(jsonStr, new TypeReference<Map<String, List<JsonDto>>>() {
        });
        stringListMap.forEach((k, v) -> {
            System.out.println(k);
            System.out.println("------");
            v.forEach(System.out::println);
        });


    }


    @Test
    public void fun2() throws JsonProcessingException {


        String str= "{\n" +
                "            \"userkey\":\"1111\",\n" +
                "                \"usersession\":\"a12345\",\n" +
                "                \"agentaction\":\"startmovie\"\n" +
                "        }";


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> stringStringMap = objectMapper.readValue(str, new TypeReference<Map<String, String>>() {
        });
        stringStringMap.forEach((k,v)->{
            log.info("key {},v {}",k,v);
        });
    }


    @Test
    public void fun3() throws JsonProcessingException {

        String str = "{\n" +
                "\t\"code\": 10000,\n" +
                "\t\"data\": {\n" +
                "\t\t\"user\": {\n" +
                "\t\t\t\"id\": 2,\n" +
                "\t\t\t\"username\": \"stn\",\n" +
                "\t\t\t\"password\": \"*********\",\n" +
                "\t\t\t\"real_name\": \"stn\",\n" +
                "\t\t\t\"email\": \"\",\n" +
                "\t\t\t\"details\": \"\",\n" +
                "\t\t\t\"enable\": \"1\",\n" +
                "\t\t\t\"create_name\": \"\",\n" +
                "\t\t\t\"create_time\": 1689921602,\n" +
                "\t\t\t\"last_edit_time\": 1689921683,\n" +
                "\t\t\t\"area_id\": 0,\n" +
                "\t\t\t\"dead_line\": 0,\n" +
                "\t\t\t\"last_login_ip\": \"\",\n" +
                "\t\t\t\"last_login_time\": 1689921649,\n" +
                "\t\t\t\"type\": \"1\",\n" +
                "\t\t\t\"role_id\": 2,\n" +
                "\t\t\t\"usergrouplist\": \"[]\",\n" +
                "\t\t\t\"useraccountgroupids\": \"[]\",\n" +
                "\t\t\t\"deptlist\": \"null\",\n" +
                "\t\t\t\"organizationids\": null,\n" +
                "\t\t\t\"organizationnames\": \"\",\n" +
                "\t\t\t\"rolename\": \"\",\n" +
                "\t\t\t\"responsetime\": 1690163369,\n" +
                "\t\t\t\"responsetype\": 1,\n" +
                "\t\t\t\"secretkey\": \"c3RuQXVkaXRzeXMyMDIxMTY4OTkyMTY3NQ==\",\n" +
                "\t\t\t\"passwordaging\": 0,\n" +
                "\t\t\t\"passwordtime\": 1692513638,\n" +
                "\t\t\t\"password_enable\": 0\n" +
                "\t\t},\n" +
                "\t\t\"token\": \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6MiwiVXNlcm5hbWUiOiJzdG4iLCJSZWFsTmFtZSI6InN0biIsIkF1dGhvcml0eUlkIjoiMiIsIkJ1ZmZlclRpbWUiOjg2NDAwLCJleHAiOjE2OTAyNDk3MDksImlzcyI6ImF1ZGl0c3lzIiwibmJmIjoxNjkwMTYyMzA5fQ.D4FTrOA8KjA31IJDZ-cknobBXIBEwcw97hMZwNUQvrM\",\n" +
                "\t\t\"expiresAt\": 1690249709000,\n" +
                "\t\t\"roles\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"id\": 2,\n" +
                "\t\t\t\t\"name\": \"普通管理员\",\n" +
                "\t\t\t\t\"create_time\": 1689921501,\n" +
                "\t\t\t\t\"create_name\": \"管理员\",\n" +
                "\t\t\t\t\"last_edit_time\": 0,\n" +
                "\t\t\t\t\"last_edit_name\": \"\",\n" +
                "\t\t\t\t\"details\": \"\",\n" +
                "\t\t\t\t\"data_range\": 0,\n" +
                "\t\t\t\t\"permissionss\": [\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 1,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1587461227,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618473380,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"主页\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 0,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/home\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-home1\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"index@dashboard\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 1,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 2,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1621409426,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"主页\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 1,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/home/main\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-zhuye\",\n" +
                "\t\t\t\t\t\t\"module\": \"main\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"main@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"main\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 2,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[253,254,120,124,178,195,305,91,146,7,311]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 100,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1595817945,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1596597859,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"检索\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 0,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/retrieval\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-jiansuo\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"retrieval\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 100,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 101,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1595818010,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1604022597,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"会话检索\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 100,\n" +
                "\t\t\t\t\t\t\"level\": \"101\",\n" +
                "\t\t\t\t\t\t\"route\": \"/retrieval/hsession\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-huihua\",\n" +
                "\t\t\t\t\t\t\"module\": \"retrieval\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"hsession@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"hsession\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 101,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[119,120,121,122,123,124,125,126,127,363,364,274]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 102,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618468948,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"视频下载\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 100,\n" +
                "\t\t\t\t\t\t\"level\": \"102\",\n" +
                "\t\t\t\t\t\t\"route\": \"/retrieval/videodown\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-shipin\",\n" +
                "\t\t\t\t\t\t\"module\": \"retrieval\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"videodown@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"videodown\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 102,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[337,338,339,340]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 300,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1615367758,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618457311,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"报表\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 0,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/report\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-baobiao\",\n" +
                "\t\t\t\t\t\t\"module\": \"report\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"report@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 300,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 310,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1615532540,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1615533785,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"指标\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 300,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/report/quota\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-zhibiao1\",\n" +
                "\t\t\t\t\t\t\"module\": \"quota\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"quota@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"quota\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 310,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[147,148,149,150]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 320,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1615428634,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1615533779,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"图表\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 300,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/report/chart\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-laiyuangailan\",\n" +
                "\t\t\t\t\t\t\"module\": \"chart\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"chart@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"chart\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 320,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[151,152,153,154,155,156,157,158,159]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 330,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618813654,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"报表规则\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 300,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/report/report\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-baobiao1\",\n" +
                "\t\t\t\t\t\t\"module\": \"report\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"reports@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"report\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 330,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[245,246,247,248,249,250,251,252,91]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 331,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618813654,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"报表任务\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 300,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/report/reportTasks\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-baobiao1\",\n" +
                "\t\t\t\t\t\t\"module\": \"reportTasks\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"reportTasks@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"reportTasks\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 331,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 345,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1633678102,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1633678102,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"报告规则\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 300,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/report/auditrule\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-anquancelue\",\n" +
                "\t\t\t\t\t\t\"module\": \"report\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"auditrule@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"auditrule\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 345,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 346,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1633678102,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1633678102,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"报告任务\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 300,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/report/auditreport\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-nlpws\",\n" +
                "\t\t\t\t\t\t\"module\": \"report\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"auditreport@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"auditreport\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 346,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 400,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1595818127,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1596597859,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"管理\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 0,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-guanli1\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"management\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 400,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 410,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618813539,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"终端\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 400,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/agents\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-zhongduanzaixianguanli\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"agents@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 410,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[365,36,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,305,320]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 412,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1595818226,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1595828801,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"终端\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 410,\n" +
                "\t\t\t\t\t\t\"level\": \"412\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/agent\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-zhongduan\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"agent@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"agent\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 412,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 415,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612433200,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612575563,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"终端升级\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 410,\n" +
                "\t\t\t\t\t\t\"level\": \"415\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/agentUpgrade\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-update\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"agentUpgrade@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"agentUpgrade\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 2,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 415,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[284,285,286,287]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 417,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618813455,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"linux终端升级\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 410,\n" +
                "\t\t\t\t\t\t\"level\": \"417\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/linuxagentUpgrade\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-ruanjianshengji\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"linuxagentUpgrade@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"linuxagentUpgrade\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 417,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[325,326,327,328,329,330,331]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 420,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1598431687,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1598431703,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"终端组\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 400,\n" +
                "\t\t\t\t\t\t\"level\": \"420\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/agentgroup\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-fuwuqi\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"agentgroup@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"agentgroup\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 420,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[27,28,29,30,31,32,33,34,35,36,92,60,66,75,82]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 440,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618452515,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"终端策略\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 400,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/policy\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-yingxiaocelveguanli\",\n" +
                "\t\t\t\t\t\t\"module\": \"policy\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"policy@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 440,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 442,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1597731078,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1622605050,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"Windows记录策略\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 440,\n" +
                "\t\t\t\t\t\t\"level\": \"442\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/recordpolicy\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-jilu1\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"recordpolicy@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"recordpolicy\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 442,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[52,53,54,55,56,57,58,59,146]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 445,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1597731322,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1622605058,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"Windows安全策略\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 440,\n" +
                "\t\t\t\t\t\t\"level\": \"445\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/securitypolicy\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-anquancelue\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"securitypolicy@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"securitypolicy\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 445,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[60,61,62,63,64,65,66,67]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 447,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1622602274,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1622605027,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"Linux记录策略\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 440,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/recordpolicy_linux\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xiangmuzonglan\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"recordpolicy_linux@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"recordpolicylinux\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 1,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[68,69,70,71,72,73,74,75,146]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 448,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1622602341,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1622605042,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"Linux安全策略\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 440,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/securitypolicy_linux\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-anquancelvepeizhi\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"securitypolicy_linux@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"securitypolicylinux\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 1,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[76,77,78,79,80,81,82,83,84]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 450,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618452553,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"组织\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 400,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/organization\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-zuzhijiagouguanli\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"org@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 450,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 454,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612511246,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612511246,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"部门\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 450,\n" +
                "\t\t\t\t\t\t\"level\": \"454\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/departments\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-bumen4\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"departments@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"departments\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 454,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[295,296,297,298,299,300,301,302,303,304,305,146,56]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 456,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1617174982,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1617174982,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"用户域组\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 450,\n" +
                "\t\t\t\t\t\t\"level\": \"456\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/useraccountgroup\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-quyuguanli\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"useraccountgroup@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"useraccountgroup\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 456,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[306,307,308,309,310,311,312,143,146]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 458,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1617267010,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1617267010,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"用户管理\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 450,\n" +
                "\t\t\t\t\t\t\"level\": \"458\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/useraccount\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-yonghuguanli\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"useraccount\",\n" +
                "\t\t\t\t\t\t\"component\": \"useraccount\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 458,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[313,314,315,316,317,318,319,320,321,322,323,324,301,302,195]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 462,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618470162,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"用户组\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 450,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/usergroup\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-yonghuzu\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"usergroup@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"usergroup\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 462,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[189,190,191,192,193,194,195,196,197,198,199,309,277,163]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 470,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618452778,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"其他认证\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 400,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/others\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-duoren\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"others@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 470,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 472,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1596014824,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1606731116,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"域配置\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 470,\n" +
                "\t\t\t\t\t\t\"level\": \"472\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/areas\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-peizhi\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"areas@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"areas\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 472,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[137,138,139,140,141,142,143,144,145,146]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 475,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1602553027,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1602553027,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"二次认证账户\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 470,\n" +
                "\t\t\t\t\t\t\"level\": \"475\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/dentification\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-renzhengyonghu\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"dentification@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"dentification\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 475,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[341,342,343,344,345,91]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 500,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1587461455,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1596597859,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"配置\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 0,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/config\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-peizhiguanli\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"config\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 500,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 550,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618452962,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"应用配置\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 500,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/config/appcon\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xitongpeizhi\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"appcon@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 550,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 553,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1596597191,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1602293656,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"应用列表\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 550,\n" +
                "\t\t\t\t\t\t\"level\": \"553\",\n" +
                "\t\t\t\t\t\t\"route\": \"/config/app\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-jincheng\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"app@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"app\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 553,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[26]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 555,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1596684651,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1602293650,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"正则列表\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 550,\n" +
                "\t\t\t\t\t\t\"level\": \"555\",\n" +
                "\t\t\t\t\t\t\"route\": \"/config/regular\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-zhengzeshi\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"regular@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"regular\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 555,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[22,23,24,25]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 557,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1600914005,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1602293661,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"数据集\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 550,\n" +
                "\t\t\t\t\t\t\"level\": \"557\",\n" +
                "\t\t\t\t\t\t\"route\": \"/config/metadata\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-database\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"metadata@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"metadata\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 557,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[132,133,134,135,136]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 559,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1614238449,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1614238449,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"表单解析规则\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 550,\n" +
                "\t\t\t\t\t\t\"level\": \"559\",\n" +
                "\t\t\t\t\t\t\"route\": \"/config/postrule\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-biaodan\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"postrule@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"postrule\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 559,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[128,129,130,131]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 600,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1587462349,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1596597859,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"系统\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 0,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xitong3\",\n" +
                "\t\t\t\t\t\t\"module\": \"system\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"system\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 600,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 0,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 609,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1595828977,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1595828977,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"区域\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 600,\n" +
                "\t\t\t\t\t\t\"level\": \"609\",\n" +
                "\t\t\t\t\t\t\"route\": \"/management/organization\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-zuzhixinxi\",\n" +
                "\t\t\t\t\t\t\"module\": \"management\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"organization@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"organization\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 452,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[40]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 610,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618453359,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"服务器\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 600,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/servers\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-fuwuqi\",\n" +
                "\t\t\t\t\t\t\"module\": \"system\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"servers@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 610,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 612,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612056990,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618453101,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"应用服务器\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 610,\n" +
                "\t\t\t\t\t\t\"level\": \"612\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/server\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-fuwuqi1\",\n" +
                "\t\t\t\t\t\t\"module\": \"system\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"server@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"server\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 612,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[85,86,87,88,89,90,91,92]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 614,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612167495,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612167495,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"备份服务器\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 610,\n" +
                "\t\t\t\t\t\t\"level\": \"614\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/dataserver\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-backup\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"dataserver@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"dataserver\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 614,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[45,46]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 616,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612174475,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612174520,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"统计服务器\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 610,\n" +
                "\t\t\t\t\t\t\"level\": \"616\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/statisticserver\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-tongji\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"statisticserver@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"statisticserver\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 616,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[41,42,43,44]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 620,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618453014,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"服务器升级\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 600,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/serversupgrade\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-2-3shengji\",\n" +
                "\t\t\t\t\t\t\"module\": \"system\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"serversup\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 620,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 621,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 0,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"控制台升级\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 620,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/centerupgradebackups\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-update\",\n" +
                "\t\t\t\t\t\t\"module\": \"system\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"centerupgradebackups@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"centerupgradebackups\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 0,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[332,333,334,335,336]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 622,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612580220,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612580281,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"应用服务器升级\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 620,\n" +
                "\t\t\t\t\t\t\"level\": \"622\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/serverupgrade\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-zcpt-yingyongshengji\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"serverupgrade@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"serverupgrade\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 622,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[282,283]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 624,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612604482,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612604482,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"备份服务器升级\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 620,\n" +
                "\t\t\t\t\t\t\"level\": \"624\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/dataserverupgrade\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-2-3-1zhongduanshengji\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"dataserverupgrade@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"dataserverupgrade\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 624,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[361,362]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 626,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612604520,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612604520,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"统计服务器升级\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 620,\n" +
                "\t\t\t\t\t\t\"level\": \"626\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/statisticserverupgrade\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-shengban-shengji\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"statisticserverupgrade@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"statisticserverupgrade\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 626,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[43]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 630,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1587461597,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612167363,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"管理员\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 600,\n" +
                "\t\t\t\t\t\t\"level\": \"39\",\n" +
                "\t\t\t\t\t\t\"route\": \"/permissions/users\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xitongguanliyuan\",\n" +
                "\t\t\t\t\t\t\"module\": \"permissions\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"user@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"users\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 630,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[8,9,10,11,12,195,305,91,146,7,311]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 635,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1587461939,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612167358,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"角色管理\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 600,\n" +
                "\t\t\t\t\t\t\"level\": \"39\",\n" +
                "\t\t\t\t\t\t\"route\": \"/permissions/roles\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-jiaose\",\n" +
                "\t\t\t\t\t\t\"module\": \"permissions\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"role@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"roles\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 635,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[1,2,3,4,5,6,7,16]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 650,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1587462147,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612167265,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"菜单管理\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 600,\n" +
                "\t\t\t\t\t\t\"level\": \"39\",\n" +
                "\t\t\t\t\t\t\"route\": \"/permissions/rules\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-caidanguanli3\",\n" +
                "\t\t\t\t\t\t\"module\": \"permissions\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"permission@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"rules\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 650,\n" +
                "\t\t\t\t\t\t\"status\": 2,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 660,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1619407466,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"系统配置\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 600,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/systemconfig\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xtrz\",\n" +
                "\t\t\t\t\t\t\"module\": \"system\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"systemconfig\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 660,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 665,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612232146,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612232146,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"es配置\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 660,\n" +
                "\t\t\t\t\t\t\"level\": \"665\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/esconfig\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-elasticsearch\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"esconfig@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"esconfig\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 1,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 665,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[49,50,51]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 670,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612246009,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612246009,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"rsyslog配置\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 660,\n" +
                "\t\t\t\t\t\t\"level\": \"670\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/rsyslogconfig\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-tongbu\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"rsyslog@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"rsyslogconfig\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 1,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 670,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[47,48]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 675,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1612251299,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612251299,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"邮箱配置\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 660,\n" +
                "\t\t\t\t\t\t\"level\": \"675\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/mailbox\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-youxiang\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"mailbox@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"mailbox\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 675,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[220,221,222]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 680,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618819050,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"插件管理\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 600,\n" +
                "\t\t\t\t\t\t\"level\": \"680\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/plugin\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-chajian1\",\n" +
                "\t\t\t\t\t\t\"module\": \"system\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"plugin@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"plugin\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 1,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 680,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[288,289,290,291,292,293,294]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 690,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1597730722,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1612167536,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"许可证\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 600,\n" +
                "\t\t\t\t\t\t\"level\": \"610\",\n" +
                "\t\t\t\t\t\t\"route\": \"/permissions/serialnumber\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-zhengjianhaoma\",\n" +
                "\t\t\t\t\t\t\"module\": \"system\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"serialnumber@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"serialnumber\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 690,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 0,\n" +
                "\t\t\t\t\t\t\"routers\": \"[209,210,211,212,213,214,215]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 700,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1616553130,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1616553130,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"监控\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 0,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/monitor\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-jiankong\",\n" +
                "\t\t\t\t\t\t\"module\": \"monitor\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"monitor\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 700,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 701,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1621564223,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1621564223,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"定时任务\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 700,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/schedule\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-rizhiguanli\",\n" +
                "\t\t\t\t\t\t\"module\": \"monitor\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"schedule@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"schedule\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 1,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[255,256,257]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 710,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1616981811,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1616981996,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"概览\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 700,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/overview\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-gailan\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"overview@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"overview\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 710,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[223,224,225,226,227,228,229,230,231,232,233,234]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 720,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1617845540,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618455031,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"es监控\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 700,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/esmonitoring\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-ES\",\n" +
                "\t\t\t\t\t\t\"module\": \"esmonitoring\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"esmonitoring@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"esmonitoring\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 720,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[235,236,237,238,239,240,241,242,243,244]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 740,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1624010015,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"监控明细\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 700,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/monitordetail\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-jiankong\",\n" +
                "\t\t\t\t\t\t\"module\": \"monitordetail\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"monitordetail\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 740,\n" +
                "\t\t\t\t\t\t\"status\": 2,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 741,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1617009956,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1624009935,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"控制台\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 740,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/console\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-guanlizhongxin\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"console@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"console\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 6,\n" +
                "\t\t\t\t\t\t\"status\": 2,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 742,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1617790995,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1624009934,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"应用服务器监控\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 740,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/serverstate\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-fuwuqi2\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"serverstate@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"serverstate\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 712,\n" +
                "\t\t\t\t\t\t\"status\": 2,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 745,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1617779617,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1624010016,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"统计服务器监控\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 740,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/statisticserverstate\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-fuwuqi4\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"statisticserverstate@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"statisticserverstate\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 715,\n" +
                "\t\t\t\t\t\t\"status\": 2,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 747,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1618987233,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1624010018,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"备份服务器监控\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 740,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/dataserverstate\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-jiankong2\",\n" +
                "\t\t\t\t\t\t\"module\": \"dataserverstate\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"dataserverstate@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"dataserverstate\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 1,\n" +
                "\t\t\t\t\t\t\"status\": 2,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 750,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1618453043,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"日志\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 700,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/monitor/\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-caozuorizhi\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"adminlog\",\n" +
                "\t\t\t\t\t\t\"component\": \"pageView\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 750,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 752,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1616571666,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1616571666,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"管理员日志\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 750,\n" +
                "\t\t\t\t\t\t\"level\": \"752\",\n" +
                "\t\t\t\t\t\t\"route\": \"/monitor/adminlog\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xitongrizhi\",\n" +
                "\t\t\t\t\t\t\"module\": \"monitor\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"get\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"adminlog@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"adminlog\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 752,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[216,217]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 754,\n" +
                "\t\t\t\t\t\t\"createdAt\": 0,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 0,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"系统日志\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 750,\n" +
                "\t\t\t\t\t\t\"level\": \"754\",\n" +
                "\t\t\t\t\t\t\"route\": \"/monitor/syslog\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xitongrizhi2\",\n" +
                "\t\t\t\t\t\t\"module\": \"monitor\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"syslog@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"syslog\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 754,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[218,219]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 766,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1624088821,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1624089119,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"安全策略\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 660,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/loginconfig\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xitongpeizhi\",\n" +
                "\t\t\t\t\t\t\"module\": \"config\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"loginconfig@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"loginconfig\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 1,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"[187,188]\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 767,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1624933305,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1624933305,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"界面定制\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 660,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/system/otherconf\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xitongpeizhi\",\n" +
                "\t\t\t\t\t\t\"module\": \"otherconf\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"otherconf@index\",\n" +
                "\t\t\t\t\t\t\"component\": \"otherconf\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 1,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 769,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1630909054,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1630909054,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"更多配置\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 660,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/config/moreconf\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xitongpeizhi\",\n" +
                "\t\t\t\t\t\t\"module\": \"moreconf\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"moreconf@method\",\n" +
                "\t\t\t\t\t\t\"component\": \"moreconf\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 1,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 770,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1630909094,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1630909095,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"转发策略\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 660,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/config/forwardingstrategy\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-xitongpeizhi\",\n" +
                "\t\t\t\t\t\t\"module\": \"forwardingstrategy\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"forwardingstrategy@method\",\n" +
                "\t\t\t\t\t\t\"component\": \"forwardingstrategy\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 1,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": 774,\n" +
                "\t\t\t\t\t\t\"createdAt\": 1633678102,\n" +
                "\t\t\t\t\t\t\"updatedAt\": 1633678102,\n" +
                "\t\t\t\t\t\t\"permission_name\": \"会话集\",\n" +
                "\t\t\t\t\t\t\"parent_id\": 100,\n" +
                "\t\t\t\t\t\t\"level\": \"\",\n" +
                "\t\t\t\t\t\t\"route\": \"/retrieval/conversationset\",\n" +
                "\t\t\t\t\t\t\"icon\": \"icon-baobiaobiaoweiguanli\",\n" +
                "\t\t\t\t\t\t\"module\": \"retrieval\",\n" +
                "\t\t\t\t\t\t\"creatorId\": 1,\n" +
                "\t\t\t\t\t\t\"method\": \"\",\n" +
                "\t\t\t\t\t\t\"permission_mark\": \"conversationset\",\n" +
                "\t\t\t\t\t\t\"component\": \"conversationset\",\n" +
                "\t\t\t\t\t\t\"redirect\": \"\",\n" +
                "\t\t\t\t\t\t\"hide_children_in_menu\": 2,\n" +
                "\t\t\t\t\t\t\"keepalive\": 1,\n" +
                "\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\"sort\": 1,\n" +
                "\t\t\t\t\t\t\"status\": 1,\n" +
                "\t\t\t\t\t\t\"position\": 1,\n" +
                "\t\t\t\t\t\t\"routers\": \"\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t],\n" +
                "\t\t\t\t\"routers\": null,\n" +
                "\t\t\t\t\"halfCheckedKeys\": \"[]\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"directrouter\": \"/home/main\"\n" +
                "\t},\n" +
                "\t\"msg\": \"登录成功\"\n" +
                "}";


//        log.info();
        VideoRes videoRes = JsonUtil.toObject(str, VideoRes.class);
        Integer code = videoRes.getCode();
        System.out.println(code);

        Map<String, Object> map2 = JsonUtil.toObject(JsonUtil.toString(videoRes.getData()), new TypeReference<Map<String, Object>>() {
        });
        String token = (String) map2.get("playurl");


//        stringStringMap.get()

    }
}


@Data
class JsonDto {
    long id;
    int qty;
    String type;
    String time;
}


@Data
class VideoRes {

    private Integer code;
    private Object data;
    private String msg;
}