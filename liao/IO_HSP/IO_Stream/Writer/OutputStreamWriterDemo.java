package IO_HSP.IO_Stream.Writer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class OutputStreamWriterDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\Writer\\a.txt";
        String data = "jhh纪浩瀚";
        BufferedWriter bw =null;
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(filepath),"gbk");
            bw = new BufferedWriter(osw);
            try {
                bw.write(data);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            try {
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
