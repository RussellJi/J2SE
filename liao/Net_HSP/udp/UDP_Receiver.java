package Net_HSP.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDP_Receiver {
    public static void main(String[] args) throws IOException {
        // 创建接收端，监听8888端口
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,1024);
        System.out.println("等待接收数据...");
        datagramSocket.receive(datagramPacket);
        System.out.println(datagramPacket.getLength());
        String recMsg = new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println("接收到:"+recMsg);
        // 将要发送的数据转为byte
        String sendDataStr = "ACK:"+recMsg;
        byte[] sendData = sendDataStr.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData,0,sendData.length,InetAddress.getByName("192.168.3.49"),9999);
        datagramSocket.send(sendPacket);
        datagramSocket.close();
        
    }
}
