package Net_HSP.homework.homework01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作业：
 * 1.用字符流的方式，编写CS;
 * 2.C发送"name",S接收到，返回"我是纪浩瀚";
 * 3.C发送"hobby",S接收到，返回"编写java程序";
 * 4.不是这两个问题，回复:"你说啥呢"
 */

/**
 * 服务端
 * 1.创建serversocket，监听8888端口
 * 2.等待客户端连接；
 * 3.创建字符输入流BufferedReader;
 * 4.创建字符输出流BufferedWriter;
 * 4.判断哪个问题
 *      回复问题
 * 5.关闭流
 * 6.关闭socket
 */

public class TCPServer {
    public static void main(String[] args) throws IOException {
        // * 1.创建serversocket，监听8888端口
        ServerSocket server = new ServerSocket(8888);
        // * 2.等待客户端连接；
        System.out.println("服务器已开启，等待客户端连接，端口为："+server.getLocalPort());
        Socket client = server.accept();
        // * 3.创建字符输入流BufferedReader;
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // * 4.创建字符输出流BufferedWriter;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        // * 4.判断哪个问题
        String line = null;
        while((line = br.readLine())!=null){
            System.out.println("客户端："+line);

            switch(line){
                case "quit":
                    System.out.println("客户端已断开！");
                    break;
                case "name":
                    bw.write("我是纪浩瀚");
                    bw.newLine();
                    bw.flush();
                    break;
                case "hobby":
                    bw.write("写java程序");
                    bw.newLine();
                    bw.flush();
                    break;
                default:
                    bw.write("你说啥呢！");
                    bw.newLine();
                    bw.flush();
                    break;
            }
        }
        // *      回复问题
        // * 5.关闭流
        bw.close();
        br.close();
        // * 6.关闭socket
        client.close();
        server.close();
    }
}
