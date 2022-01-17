package cn.dhx.netty.boot.entity;


import lombok.Data;

@Data
public class AudioStream {

    private String cmd;

    private String callid;

    private String caller;

    private String callee;


}
