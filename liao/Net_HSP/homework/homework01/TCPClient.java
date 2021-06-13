package Net_HSP.homework.homework01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端
 * 1.创建client，连接服务器;
 * 2.创建字符输出流，发送问题;
 * 3.创建字符输入流，接受服务器的问题;
 * 4.关闭流
 * 5.关闭socket
 */
public class TCPClient {
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        // * 1.创建client，连接服务器;
        Socket client = new Socket(InetAddress.getLocalHost(),8888);
        System.out.println("成功连接服务器！");
        // * 2.创建字符输出流，发送问题;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String line = null;
        while(true) {
            System.out.println("请输入问题：");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();

            bw.write(msg);
            bw.newLine();
            bw.flush();
            if(msg.equals("quit")){

                break;
            }
            if((line = br.readLine()) != null){
                System.out.println("服务器："+line);
            }
        }

        // * 3.创建字符输入流，接受服务器的回复;
//        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        String line = null;
//        if((line = br.readLine()) != null){
//            System.out.println(line);
//        }
        // * 4.关闭流

//        Read read = new Read();
//        read.start();
        br.close();
        bw.close();
        
        // * 5.关闭socket
        client.close();

    }
}
//class Read extends Thread{
//
//    public void run(Socket client) throws IOException {
//        // * 3.创建字符输入流，接受服务器的回复;
//        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        String line = null;
//        while((line = br.readLine()) != null){
//
//            System.out.println(line);
//        }
//        br.close();
//    }
//}