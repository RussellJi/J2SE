package Net_HSP.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP_Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] recvBytes = new byte[1024];
        // 先发送再接受
        System.out.println("请输入要发送的数据：");
        Scanner sc = new Scanner(System.in);
        String sendData = sc.nextLine();
        byte[] sendBytes = sendData.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBytes,0,sendBytes.length,InetAddress.getByName("192.168.3.49"),8888);
        datagramSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(recvBytes,1024);
        System.out.println("等待接收数据...");

        datagramSocket.receive(receivePacket);
        System.out.println(receivePacket.getLength()); 
        String recMsg = new String(receivePacket.getData(),0,receivePacket.getLength());
        System.out.println(recMsg);
        
        datagramSocket.close();
        
    }
}
