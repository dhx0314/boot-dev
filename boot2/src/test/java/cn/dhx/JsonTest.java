package cn.dhx;

import cn.dhx.boot.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}


@Data
class JsonDto {
    long id;
    int qty;
    String type;
    String time;
}
