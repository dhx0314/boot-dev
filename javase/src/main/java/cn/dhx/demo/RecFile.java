package cn.dhx.demo;


import lombok.Data;

import java.util.Date;

@Data
public class RecFile {

    private final Stu stu;
    private final Stu stu2;

    private String aa;
    private RTPSession rtpSession;


}