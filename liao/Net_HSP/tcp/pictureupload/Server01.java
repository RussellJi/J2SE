package Net_HSP.tcp.pictureupload;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 1.创建服务器，监听8888端口
 * 2.服务器接受客户端连接
 * 3.get输入流
 * 4.服务器接受图片文件（字节），每次接受1024byte
 * 5.创建输出流，写入本地的目录
 * 6.关闭输出流
 * 7.关闭输入流
 * 8.关闭socket
 * 9.关闭serversocket
 */

public class Server01 {
    public static void main(String[] args) throws IOException {

        String filepath = "Net_HSP\\socket\\tcp\\pictureupload\\esp.txt";
        // 1.创建服务器，监听8888端口
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器已开启："+server.toString());
        System.out.println("等待客户端连接......");
        // 2.服务器接受客户端连接
        Socket socket = server.accept();
        System.out.println("客户端已连接："+socket.toString());
        // 3.get输入流
        InputStream is = socket.getInputStream();
        BufferedOutputStream bos = null;
        // OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        // 4.服务器接受图片文件（字节），每次接受1024byte
        byte[] bytes = new byte[1024];
        int dataLen = 0;
        while((dataLen = is.read(bytes))!=-1){
            bos = new BufferedOutputStream(new FileOutputStream(filepath,true));
            String msg = new String(bytes,0,dataLen);
            if(msg.equals("发送完毕")){
                System.out.println("客户端：文件上传成功！");
                
                break;
            }
            byte[] b = msg.getBytes();
            bos.write(b);
            bos.close();

        }
        bw.write("接收文件成功");
        bw.newLine();
        bw.close();
        is.close();
        socket.close();
        server.close();

    }
}
