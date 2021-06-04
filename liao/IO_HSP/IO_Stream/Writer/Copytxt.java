package IO_HSP.IO_Stream.Writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copytxt {
    public static void main(String[] args){
        String srcpath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\Reader\\hello.txt";
        String destpath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\Writer\\hello.txt";
        String line = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(srcpath));
            bw = new BufferedWriter(new FileWriter(destpath));
            while((line = br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
            System.out.println("拷贝完毕");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
    }
}
