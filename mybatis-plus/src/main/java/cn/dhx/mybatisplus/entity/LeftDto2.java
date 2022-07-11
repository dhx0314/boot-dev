package cn.dhx.mybatisplus.entity;


import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class LeftDto2 extends Filedetail{

    private List<MyTest> myTests;
}
