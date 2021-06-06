package Net_HSP.tcp.bytedemo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client01 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket =null;
        // Socket socket = new Socket("127.0.0.1",9999);
        try {
            socket = new Socket(InetAddress.getLocalHost(),9999);
            System.out.println(socket.toString());
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        assert socket != null;
        OutputStream os = socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = null;
        while(true){
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            byte[] b = msg.getBytes();
            os.write(b);

            if(msg.equals("quit")){
                break;
            }
            if((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        os.close();
        socket.close();
        

  
    }
}