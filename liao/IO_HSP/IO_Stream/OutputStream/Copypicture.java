package IO_HSP.IO_Stream.OutputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copypicture {
    public static void main(String[] args){
        String srcpath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\volleyball.png";
        String destpath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\OutputStream\\volley.png";
        byte[] b = new byte[1024];
        int dataLen = 0;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcpath));
            bos = new BufferedOutputStream(new FileOutputStream(destpath));
            while((dataLen = bis.read(b))!=-1){
                bos.write(b,0,dataLen);
            }
            System.out.println("拷贝完毕");



            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
    }
}
