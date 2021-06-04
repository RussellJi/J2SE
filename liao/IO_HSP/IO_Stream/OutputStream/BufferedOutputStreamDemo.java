package IO_HSP.IO_Stream.OutputStream;

import java.io.BufferedOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        fileWriter();
    }
    public static void fileWriter() throws IOException{
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\OutputStream\\hello.txt";
        String data = "jhh张书嫚";
        BufferedOutputStream bos  = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(filepath,true));
            bos.write(data.getBytes());
            System.out.println("写入完毕");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            bos.close();
        }
    }
}
