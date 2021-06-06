package Net_HSP.socket.tcp.bytedemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器已开启："+serverSocket.toString());
        Socket socket = serverSocket.accept();
        System.out.print("客户端已连接：");
        System.out.println(socket.toString());
        int dataLen = 0;
        byte[] b = new byte[1024];
        InputStream is = null;
        is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        while((dataLen = is.read(b))!=-1){
            String msg = new String(b,0,dataLen);
            System.out.println(msg);
            os.write("ack:".getBytes());
            os.write(msg.getBytes());
            if(msg.equals("quit")){
                System.out.println("客户端退出");
                break;
            }
        }
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
        
        
    }
}
