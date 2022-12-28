package cn.dhx.bootdemo.demo;

public class Demo10 {

    public static void main(String[] args) {

//        String url="http://172.16.2.88:9090/driver/v1/tsapi/getConfirmation/Recorderb8GEBJ";
        String url="/driver/v1/tsapi/getConfirmation/Recorderb8GEBJ";
        String temp[] =url.split("/");
        //System.out.println("url count:"+temp.length);
        String method = temp[4];
        if(temp.length==6) {
            String body = temp[5];
        }
        for (String s : temp) {
            System.out.println(s);
        }

    }
}
