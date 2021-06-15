package QQClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;


/**
 * 客户端连接服务器
 * 创建输入流
 */
public class ClientA {
    public static void main(String[] args) throws UnknownHostException, IOException {
        //连接服务器
        Socket socket  = new Socket(InetAddress.getByName("127.0.0.1"),9999);
        System.out.println("已连接服务器："+socket.toString());
        //创建输入输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String sendline = null;
        String recvline = null;
//        Scanner sc = new Scanner(System.in);
        int flag = 3;
        Date date = new Date();
        while(true){

//            sendline = sc.nextLine();
//            bw.write(sendline);
//            bw.newLine();
//            bw.flush();
//            if(sendline.equals("quit")){
//                System.out.println("客户端即将退出");
//                break;
//            }
            if((recvline = br.readLine())!=null){
                System.out.println(date.toString());
                System.out.println("收到了消息"+recvline);

            }

        }
//        sc.close();
//        socket.close();
    }
}
