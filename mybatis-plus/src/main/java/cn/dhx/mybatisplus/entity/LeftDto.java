package cn.dhx.mybatisplus.entity;


import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class LeftDto extends Filedetail {

    private String pathname;

    private String httpdURL;


}
