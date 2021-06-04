package IO_HSP.IO_Stream.Reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class InputStreamReaderDemo {
    public static void main(String[] args) {
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\Reader\\a.txt";
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(new FileInputStream(filepath),"gbk");
            br = new BufferedReader(isr);
            try {
                // while(isr.read()!=-1){
                //     System.out.println((char)isr.read());
                // }
                System.out.println(br.readLine());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }
}
