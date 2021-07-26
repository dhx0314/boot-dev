package cn.dhx.boot.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPSendTest {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket =  new DatagramSocket(10000);
            byte[] data = "hello,udp\n".getBytes();
            int port = 8080;
//            InetAddress address = InetAddress.getByName("192.168.253.101");
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            socket.send(packet);

//            byte[] buffer = new byte[1024];
//            DatagramPacket receiver = new DatagramPacket(buffer, buffer.length);
//            socket.receive(receiver);
//            String res = new String(receiver.getData(),0,receiver.getLength());
//            System.out.println("response by server : "+res);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }
}
