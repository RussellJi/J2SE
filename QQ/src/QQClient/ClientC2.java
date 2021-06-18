package QQClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


/**
 * 客户端：
 * 1.当客户端连接到服务器时，返回一个socket，通过该socket与之通信；
 * 2.每当连接到一个服务器时，创建一个线程持有该socket，即socket为线程的属性； 
 * 3.通过Msg、User对象与服务器进行数据的收发；
 * 4.当客户端输入Q退出时，通知服务器无异常退出（服务器要关闭socket），同时关闭自己的socket并结束程序
 */

public class ClientC2 {
    public volatile static ArrayList<ObjHandleThread> threadArray = new ArrayList<>();
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket  = new Socket(InetAddress.getByName("127.0.0.1"),9999);
        System.out.println("已连接服务器："+socket.toString());
        //创建一个线程
        ObjHandleThread thread = new ObjHandleThread(socket);
        thread.start();
        threadArray.add(thread);

    }
}
