package IO_HSP.IO_Stream.Reader;

import java.io.FileReader;
import java.io.IOException;

/**
 * 1.继承关系 FileReader extends InputStreamReader extends Reader
 * 2.
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        fileReader02();
    }
    // 单个字符读取
    public static void fileReader01() throws IOException{
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\Reader\\hello.txt";
        FileReader fr = null;
        int readData = 0;
        try {
            fr = new FileReader(filepath);
            while((readData = fr.read())!=-1){
                System.out.println((char)fr.read());
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            fr.close();
        }
    }
    public static void fileReader02() throws IOException{
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\Reader\\hello.txt";
        FileReader fr = null;
        // 3个字符一块读
        char[] c =new char[3];
        int readLen = 0;
        try {
            fr = new FileReader(filepath);
            while((readLen = fr.read(c))!=-1){
                System.out.println(new String(c,0,readLen));
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            fr.close();
        }
    }
}

