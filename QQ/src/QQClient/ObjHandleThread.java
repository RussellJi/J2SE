package QQClient;
import QQServer.QQServer;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import static QQClient.ClientC.threadArray;

public class ObjHandleThread extends Thread{
    //持有socket
    private final Socket socket;
    ObjHandleThread(Socket socket){
        this.socket = socket;
    }

    public Socket getSocket() {
        return this.socket;
    }

    @Override
    public void run() {

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Msg msg;
        
        Scanner sc = new Scanner(System.in);
        String sendData;
        System.out.println("nihao");
        boolean flag = true;
        while(flag){

            //创建MSg对象，将其发送给指定的客户端

            sendData = sc.nextLine();
            msg = new Msg("0","0",MIME.TXT,sendData);
            try {
                assert oos != null;
                oos.writeObject(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                ois = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert false;
                while((msg = (Msg) ois.readObject()) != null){
                    System.out.println(new Date().toString());
                    System.out.println("收到客户端"+msg.getSource()+":"+msg.getContent());

                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            //退出
            if(sendData.equals("q")){
                //输出退出时间
                System.out.print(new Date().toString());
                System.out.println("客户端已退出！");
                flag  = false;
                try {
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}

