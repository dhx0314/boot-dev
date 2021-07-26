package cn.dhx.boot.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiveTest implements Runnable {

    private final int MAX_SIZE = 1024;
    private final int PORT = 8080;

    private DatagramSocket socket;

    public static void main(String[] args) {
        new Thread(new UDPReceiveTest()).start();
    }

    @Override
    public void run() {
        try {
            socket = new DatagramSocket(PORT);
            System.out.println("UDP server start.");
            int count = 0;
            while(true) {
                byte[] buffer = new byte[MAX_SIZE];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                InetAddress address = packet.getAddress();
                System.out.println(address);
                socket.receive(packet);
                String data = new String(packet.getData(),0,packet.getLength());
                System.out.println("server receive data : "+data);
                byte[] send = String.format("yes,udp server. %d times", count++).getBytes();
                packet.setData(send);
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }
}