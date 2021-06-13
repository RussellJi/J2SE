package QQServer;

import QQClient.MIME;
import QQClient.Msg;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class ObjHandleThread extends Thread{
    //持有socket
    private static Socket socket = null;
    ArrayList<Thread> threadArray = null;
    Date date = new Date();
    ObjHandleThread(Socket socket, ArrayList<Thread> threadArray){
        ObjHandleThread.socket = socket;
        this.threadArray = threadArray;
    }

    public static Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {

        ObjectInputStream ois = null;
        BufferedWriter bw = null;
        Msg msg = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while(true){
                assert ois != null;
                if ((msg = (Msg) ois.readObject()) == null)
                    break;
                switch (msg.getType()){
                    case TXT:
                        String data = msg.getContent();
                        if (msg.getDestination().equals("0")){
                            System.out.println(date.toString());
                            System.out.println("服务器：收到了发给0号客户端的消息，"+data);

                        }
                        if (msg.getDestination().equals("1")){
                            System.out.println(date.toString());
                            System.out.println("服务器：收到了发给1号客户端的消息，"+data);

                        }
                        break;
                    case IMG:
                    case VIDEO:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(bw != null)
                    bw.close();
                if(ois != null)
                    ois.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

