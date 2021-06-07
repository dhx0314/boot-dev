package cn.dhx.boot.thread2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class Stu {

    private String name;

    private ArrayList<String> list=new ArrayList<>();



    @Autowired
    private ServiceDemo2 serviceDemo2;

    public void funa() {

//        ServiceDemo2 serviceDemo21 = new ServiceDemo2();
//        System.out.println(this.serviceDemo2);
//        serviceDemo21.fun1(this,"tt");

        ServiceDemo2.fun1(this,"aa");

        System.out.println("-------------------");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
