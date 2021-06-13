package QQServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;


public class HandlerThread extends Thread{
    private static Socket socket = null;

    public HandlerThread(Socket socket, ArrayList<Thread> threadArray) {
        HandlerThread.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
    
    @Override
    public void run() {
        System.out.println("建立一个线程"+Thread.currentThread().getName());
        BufferedWriter bw = null;
        BufferedReader br  = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String sendline = null;
            String recvline = null;
            while((recvline = br.readLine())!=null){
                System.out.println("客户端："+socket.toString()+recvline);
                sendline = "ack"+recvline;
                bw.write(sendline);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e1) {
            
            e1.printStackTrace();
        }finally{
            
            try {
                bw.close();
                br.close();
                socket.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
