package Net_HSP.homework.homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP homework
 * 1.接收端在8888端口等待接收数据
 * 2.发送端发送:"四大名著是哪些？"
 * 3.接收端返回:"四大名著：红楼梦，水浒传，三国演义，西游记。"
 * 4.否则返回what
 */
public class UDPSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket sendSocket = new DatagramSocket(9999);
        while(true){
            System.out.println("请输入问题：");
            Scanner sc = new Scanner(System.in);
//        String sendData = "四大名著？";
            String sendData = sc.nextLine();

            byte[] sendByte = sendData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendByte,0,sendByte.length,InetAddress.getByName("127.0.0.1"),8888);
            sendSocket.send(sendPacket);
            if (sendData.equals("quit")){

                break;
            }
            byte[] recvdata = new byte[1024];
            DatagramPacket recvPacket = new DatagramPacket(recvdata,1024);
            sendSocket.receive(recvPacket);
            String question = new String(recvPacket.getData(),0,recvPacket.getLength());
            System.out.println("收到答案："+question);
        }




        
        sendSocket.close();




    }
}
