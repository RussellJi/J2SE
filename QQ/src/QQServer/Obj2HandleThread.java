package QQServer;

import QQClient.Msg;

import java.io.*;
import java.net.Socket;
import java.util.Date;

import static QQServer.QQServer.threadArray;

public class Obj2HandleThread extends Thread{
    //持有socket
    private Socket socket = null;
    Date date = new Date();
    Obj2HandleThread(Socket socket){
        this.socket = socket;


    }

    public Socket getSocket() {
        return this.socket;
    }

    @Override
    public void run() {

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        Msg msg = null;
        
        try {
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert false;
            while((msg = (Msg) ois.readObject()) != null){
                //获取接收消息客户端的线程id
                int destid = Integer.parseInt(msg.getDestination());
                if(msg.getContent().equals("q")){
                    System.out.println("客户端已退出："+socket.toString());
                    socket.close();
                    break;
                }
                try {
                    System.out.println(destid);
                    oos = new ObjectOutputStream(threadArray.get(destid).getSocket().getOutputStream());

                    oos.writeObject(msg);

                    oos.flush();
                    oos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

