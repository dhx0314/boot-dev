package cn.dhx.boot.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

public class Demo7 {

    public static void main(String[] args) {
//        String s = null;
//        String s2="";
//        System.out.println("2".equals(s));
//        System.out.println("2".equals(s2));

        String s="{\n" +
                "\t\"agentMode\": \"NotReady\",\n" +
                "\t\"status\": \"NotReady\",\n" +
                "\t\"agentId\": \"3801002\",\n" +
                "\t\"agentStatus\": \"NotReady\",\n" +
                "\t\"deviceId\": \"3601002\"\n" +
                "\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String agentId1 = jsonNode.get("agentId").asText();
        if (StringUtils.isNotBlank(agentId1)) {
            System.out.println(agentId1);
        }

    }
}
