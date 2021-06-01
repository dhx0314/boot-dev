package cn.dhx.boot.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GitDemo2 {


    public static void main(String[] args) {
        String code="-1";
        switch (code) {
            case "-1":
                System.out.println("---");
                break;
            case "1":
                System.out.println("111");
        }

        ObjectMapper objectMapper = new ObjectMapper();

    }
}