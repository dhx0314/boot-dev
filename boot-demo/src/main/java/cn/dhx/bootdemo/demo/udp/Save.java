package cn.dhx.bootdemo.demo.udp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


@Component
@Slf4j
public class Save {

    //    public static void main(String[] args) throws Exception {
    @PostConstruct
    public void start() {
        new Thread(()->{
            try {
                fun();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }



    public  void fun() throws Exception {


        // 定义一个接收端，并且指定了接收的端口号
//        DatagramSocket socket = new DatagramSocket(19993, InetAddress.getByName("172.16.2.155"));
        DatagramSocket socket = new DatagramSocket(19993);

        while (true) {
            byte[] buf = new byte[1024];
            // 解析数据包
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            socket.receive(packet);

            String ip = packet.getAddress().getHostAddress();

            buf = packet.getData();

            String data = new String(buf, 0, packet.getLength());

//            System.out.println("收到 " + ip + " 发来的消息：" + data);
            log.info("{} message {} ",ip,data.length());


        }

    }
}
