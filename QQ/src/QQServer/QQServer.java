package QQServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;


/**
 * 1.服务器监听9999
 * 2.一个线程处理一个连接请求，即每个线程都持有一个socket可以与客户端进行通信；
 * 3.用线程集合管理线程；
 * 疑问1：每个线程持有socket，也就是socket是在线程中接收连接的，怎么知道什么时候开启线程呢
 * 解决1：当有客户端连接时，将返回的socket对象作为参数初始化线程的构造函数
 * 4.若两个客户端进行通信，则必须经过服务器
 *  A:创建一个ObjectOutputStream，发送消息对象（消息的格式，内容，消息的接收者）
 *  服务器创建一个ObjectOutputStream，接收A发送的消息对象，解析，创建一个输出流给特定的socket发送特定的消息
 *
 *
 */
public class QQServer {
    public volatile static ArrayList<Obj2HandleThread> threadArray = new ArrayList<>();
    public static void main(String[] args) throws IOException {
//        开启服务器监听9999
        ServerSocket server = new ServerSocket(9999);
        System.out.println("服务器已开启："+server.toString());
//        创建一个线程集合

//        HashMap<String,Thread> threadMap = new HashMap<String,Thread>();
        Socket socket;
        Date date = new Date();
        while((socket = server.accept())!=null){
            System.out.println(date.toString()+":");
            System.out.println("客户端已连接："+socket.toString());
//            HandlerThread thread = new HandlerThread(socket,threadArray);
            Obj2HandleThread thread = new Obj2HandleThread(socket);
//            threadMap.put("",thread);
            threadArray.add(thread);

            thread.start();
        }

        server.close();
    }
}












