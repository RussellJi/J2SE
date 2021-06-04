package IO_HSP.IO_Stream.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReadDemo {
    public static void main(String[] args) {
        readFile01();
    }

    public static void readFile01(){
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\InputStream\\hello.txt";
        BufferedReader bf = null;
        String line;
        try {
            bf = new BufferedReader(new FileReader(filepath));
            while((line = bf.readLine())!=null){
                System.out.println(line);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
