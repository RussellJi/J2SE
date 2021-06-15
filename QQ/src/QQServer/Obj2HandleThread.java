package QQServer;

import QQClient.Msg;

import java.io.*;
import java.net.Socket;

import java.util.ArrayList;
import java.util.Date;

import static QQServer.QQServer.threadArray;

public class ObjHandleThread extends Thread{
    //持有socket
    private Socket socket = null;
    Date date = new Date();
    ObjHandleThread(Socket socket){
        this.socket = socket;


    }

    public Socket getSocket() {
        return this.socket;
    }

    @Override
    public void run() {

        ObjectInputStream ois = null;
        BufferedWriter bw = null;
        BufferedWriter bw2 = null;
        Msg msg;
        try {
            ois = new ObjectInputStream(socket.getInputStream());

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
                            //要给0号线程处理的客户端发送消息
                            Socket destSocket = threadArray.get(0).getSocket();
                            bw = new BufferedWriter(new OutputStreamWriter(destSocket.getOutputStream()));
                            bw.write(data);
                            bw.newLine();
                            bw.flush();
                            bw.close();
                            System.out.println(date.toString());

                            System.out.println("服务器：收到了发给0号客户端的消息，"+data);

                        }
                        if (msg.getDestination().equals("1")){
                            Socket destSocket2 = threadArray.get(1).getSocket();
                            bw2 = new BufferedWriter(new OutputStreamWriter(destSocket2.getOutputStream()));
                            bw2.write(data);
                            bw2.newLine();
                            bw2.flush();
                            bw2.close();
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

