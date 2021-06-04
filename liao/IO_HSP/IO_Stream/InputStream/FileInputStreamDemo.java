package IO_HSP.IO_Stream.InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 */

@SuppressWarnings("all")
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        readFile02();
        
    }

    // 在文件中读取字节，并转为字符输出
    public static void readFile01() throws IOException{
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\InputStream\\hello.txt";
        FileInputStream fis = null;
        int readData = 0;
        try {
            // 创建fis对象，用于读取文件
            fis = new FileInputStream(filepath);

            // 单个字节连续读取效率低
            while((readData=fis.read()) != -1){
                System.out.println((char)readData);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            fis.close();
        }
        
    }

    // 一次读三个字节，拼成汉字
    public static void readFile02() throws IOException{
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\InputStream\\hello.txt";
        FileInputStream fis = null;
        int readLen = 0;
        byte[] buf = new byte[3];
        try {
            // 创建fis对象，用于读取文件
            fis = new FileInputStream(filepath);

            // 3个字节连续读取，并将3个字节拼成一个字符串显示,3个字节对应一个中文字符
            // 正常返回每次读取的字节数
            // 返回-1，读取完毕
            while((readLen=fis.read(buf)) != -1){
                
                System.out.println(new String(buf,0,3));
                
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            fis.close();
        }
        
    }
}
