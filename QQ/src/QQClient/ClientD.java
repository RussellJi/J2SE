package QQClient;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import static QQServer.QQServer.threadArray;

public class ClientD {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket  = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert socket != null;
        System.out.println("已连接服务器："+socket.toString());
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //创建消息对象
//        Msg msg = new Msg("2","0",MIME.TXT,"hello ClientA");
//        //创建对象输出流
//        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//        oos.writeObject(msg);
//        socket.shutdownOutput();

        //接收Msg对象并解析
        //创建对象输入流
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Msg msg = null;
        Date date = new Date();


        //bug不能连续接收msg对象,会异常退出

        while(true){
            assert ois != null;
            if ((msg = (Msg) ois.readObject()) == null) break;
            System.out.println(date.toString()+":");
            System.out.println(msg.getContent());
        }



    }
}
