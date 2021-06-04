package IO_HSP.IO_Stream.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        fileWriter03();
    }
    public static void fileWriter01() throws IOException{
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\Writer\\hello.txt";
        String data = "纪浩瀚张书嫚";
        
        FileWriter fw = null;
        try {
            fw = new FileWriter(filepath);
            fw.write(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            fw.close();
        }
    }
    // 写入字符串指定部分
    public static void fileWriter02() throws IOException{
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\Writer\\hello.txt";
        String data = "纪浩瀚张书嫚";
        
        FileWriter fw = null;
        try {
            fw = new FileWriter(filepath,true);
            fw.write(data,0,3);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            fw.close();
        }
    }
    public static void fileWriter03() throws IOException{
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\Writer\\hello.txt";
        String data = "纪浩瀚张书嫚";
        char[] c = data.toCharArray();
        FileWriter fw = null;
        try {
            fw = new FileWriter(filepath,true);
            fw.write(c,0,3);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            fw.close();
        }
    }
}
