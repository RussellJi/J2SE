package Net_HSP.homework.homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket recvSocket = new DatagramSocket(8888);
        byte[] recvdata = new byte[1024];
        DatagramPacket recvPacket = new DatagramPacket(recvdata,1024);
        while(true){
            recvSocket.receive(recvPacket);
            String question = new String(recvPacket.getData(),0,recvPacket.getLength());
            if(question.equals("quit")){
                System.out.println("发送端已退出");
                break;
            }

            System.out.println("收到问题："+question);
            String sendData = "四大名著：红楼梦，水浒传，三国演义，西游记。";
            String sendData2 = "what?";
            byte[] sendByte = sendData.getBytes();
            byte[] sendByte2 = sendData2.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendByte,0,sendByte.length,InetAddress.getByName("127.0.0.1"),9999);
            DatagramPacket sendPacket2 = new DatagramPacket(sendByte2,0,sendByte2.length,InetAddress.getByName("127.0.0.1"),9999);
            if(question.equals("四大名著？")){
                recvSocket.send(sendPacket);
            }else{
                recvSocket.send(sendPacket2);
            }

        }
        recvSocket.close();



    }
}
