package cn.dhx.bootdemo.demo.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] buf = "demo".getBytes();
        //将数据打包
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("172.16.2.155"), 19993);
        socket.send(packet);
        socket.close();

    }

}
