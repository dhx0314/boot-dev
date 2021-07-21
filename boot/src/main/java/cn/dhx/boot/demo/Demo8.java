package cn.dhx.boot.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo8 {

    public static void main(String[] args) throws Exception{
        String json ="[\n" +
                "    {\n" +
                "        \"businessCode\": \"1\",\n" +
                "        \"agentName\": \"小名\",\n" +
                "        \"domain\": \"laihu.com\",\n" +
                "        \"agentId\": \"10102\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"businessCode\": \"1\",\n" +
                "        \"agentName\": \"10201\",\n" +
                "        \"domain\": \"laihu.com\",\n" +
                "        \"agentId\": \"10201\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"businessCode\": \"1\",\n" +
                "        \"agentName\": \"10202\",\n" +
                "        \"domain\": \"laihu.com\",\n" +
                "        \"agentId\": \"10202\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"businessCode\": \"3\",\n" +
                "        \"agentId\": \"30101\",\n" +
                "        \"agentName\": \"30101\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentId\": \"30102\",\n" +
                "        \"businessCode\": \"3\",\n" +
                "        \"agentName\": \"30102\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentId\": \"30201\",\n" +
                "        \"businessCode\": \"3\",\n" +
                "        \"agentName\": \"30201\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentId\": \"30202\",\n" +
                "        \"businessCode\": \"3\",\n" +
                "        \"agentName\": \"30202\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentId\": \"50101\",\n" +
                "        \"businessCode\": \"5\",\n" +
                "        \"domain\": \"laihu.com\",\n" +
                "        \"agentName\": \"50101\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentName\": \"50102\",\n" +
                "        \"businessCode\": \"5\",\n" +
                "        \"agentId\": \"50102\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentName\": \"50201\",\n" +
                "        \"businessCode\": \"5\",\n" +
                "        \"agentId\": \"50201\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentName\": \"50202\",\n" +
                "        \"businessCode\": \"5\",\n" +
                "        \"agentId\": \"50202\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"businessCode\": \"6\",\n" +
                "        \"agentId\": \"60101\",\n" +
                "        \"domain\": \"laihu.com\",\n" +
                "        \"agentName\": \"60101\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentId\": \"60102\",\n" +
                "        \"businessCode\": \"6\",\n" +
                "        \"domain\": \"laihu.com\",\n" +
                "        \"agentName\": \"60102\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentId\": \"60201\",\n" +
                "        \"businessCode\": \"6\",\n" +
                "        \"domain\": \"laihu.com\",\n" +
                "        \"agentName\": \"60201\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"businessCode\": \"6\",\n" +
                "        \"agentId\": \"60202\",\n" +
                "        \"agentName\": \"60202\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentId\": \"80101\",\n" +
                "        \"businessCode\": \"4\",\n" +
                "        \"agentName\": \"80101\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentId\": \"80102\",\n" +
                "        \"businessCode\": \"4\",\n" +
                "        \"agentName\": \"80102\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentId\": \"80201\",\n" +
                "        \"businessCode\": \"4\",\n" +
                "        \"agentName\": \"80201\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentName\": \"60001\",\n" +
                "        \"businessCode\": \"1\",\n" +
                "        \"agentId\": \"60001\",\n" +
                "        \"domain\": \"laihu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"agentName\": \"10103\",\n" +
                "        \"businessCode\": \"5\",\n" +
                "        \"domain\": \"laihu.com\",\n" +
                "        \"agentId\": \"10103\"\n" +
                "    }\n" +
                "]";

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> agentNameCache = new HashMap<>();
        CollectionType mapCollectionType = mapper.getTypeFactory().constructCollectionType(List.class, Map.class);
        try {
            List<Map<String, String>> result = mapper.readValue(json, mapCollectionType);
            for (Map<String, String> map : result) {
                String agentId = map.get("agentId");
                String agentName= map.get("agentName");
                agentNameCache.put(agentId,agentName);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        agentNameCache.forEach((k,v)->{
            System.out.println(k+"-----"+v);
        });
    }
}
