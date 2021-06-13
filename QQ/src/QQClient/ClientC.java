package QQClient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientC {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket  = new Socket(InetAddress.getByName("127.0.0.1"),9999);
        System.out.println("已连接服务器："+socket.toString());
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //创建消息对象
        Msg msg = new Msg(MIME.TXT,"1","hi");
        //创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(msg);
        socket.shutdownOutput();
//        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String sendline = null;
//        String recvline = null;
//        Scanner sc = new Scanner(System.in);
//        while(true){
//
//            sendline = sc.nextLine();
//            bw.write(sendline);
//            bw.newLine();
//            bw.flush();
//            if(sendline.equals("quit")){
//                System.out.println("客户端即将退出");
//                break;
//            }
//            if((recvline = br.readLine())!=null){
//                System.out.println(recvline);
//            }
//
//        }
        
//        sc.close();
        socket.close();
    }
}
