package IO_HSP.IO_Stream.InputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        readFile01();
    }

    public static void readFile01() throws IOException{
        // String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\volleyball.png";
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\InputStream\\hello.txt";
        byte[] b = new byte[3];
        int dataLen = 0;
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(filepath));
            while((dataLen = bis.read(b))!=-1){
                System.out.println(new String(b,0,dataLen));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            bis.close();
        }

    }
}
