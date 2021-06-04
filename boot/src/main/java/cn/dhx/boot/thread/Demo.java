package cn.dhx.boot.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Demo {


    @Autowired
    private Servicce servicce;

    public void fun1() {
        servicce.add();
    }


}
