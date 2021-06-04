package IO_HSP.IO_Stream.Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) {
        fileWriter01();
    }
    public static void fileWriter01(){
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\Writer\\hello.txt";
        String data = "jhh张书嫚";
        BufferedWriter bw = null;
        try {
            bw  = new BufferedWriter(new FileWriter(filepath));
            bw.write(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
