package cn.dhx.boot.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class StuDemo {
//
//    @Autowired
//    public dataDemo dataDemo;

    public dataDemo dataDemo=new dataDemo();

    private String stuname;
}
