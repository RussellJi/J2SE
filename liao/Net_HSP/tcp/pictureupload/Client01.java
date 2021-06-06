package Net_HSP.tcp.pictureupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端上传文件到服务器
 * 1.建立客户端，连接服务器，提示连接成功
 * 2.创建字节输入流，读取文件
 * 3.创建字节输出流，将文件内容输出到一个字节数组中，然后通过socket输出流将其发送给服务器
 * 4.创建socket输入流，接受服务器发来的 "接收文件成功"
 * 5.关闭socket输入流
 * 6.关闭socket输出流
 * 7.关闭字节输出流
 * 8.关闭字节输入流
 * 9.关闭socket
 */
public class Client01 {
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

        String srcpath = "Net_HSP\\socket\\tcp\\pictureupload\\nba.txt";
        // 1.建立客户端，连接服务器，提示连接成功
        System.out.println("正在连接服务器......");
        Socket socket = new Socket("127.0.0.1", 8888);
        System.out.println("服务器连接成功："+socket.toString());
        Thread.sleep(3000);
        // 2.创建字节输入流，读取文件 
        byte[] b = new byte[1024];
        int dataLen = 0;
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcpath));
        // 3.创建字节输出流，将文件内容输出到一个字节数组中，然后通过socket输出流将其发送给服务器
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        while((dataLen = bis.read(b)) != -1){
            bos.write(b,0,dataLen);
            bos.flush();
        }

        System.out.println("发送完毕");
        bos.write("发送完毕".getBytes());
        bos.flush();
        socket.shutdownOutput();
        // 4.创建socket输入流，接受服务器发来的 "接收文件成功"
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = null;
        while((line = br.readLine())!=null){
            if(line.equals("接收文件成功")){
                System.out.println("服务器：接收文件成功");
                break;
            }
        }
        br.close();
        bis.close();
        bos.close();
        socket.close();
        

    }
}
