package IO_HSP.homework.homework02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

// 使用BufferedReader 读取一个文本文件，为每行加上行号，再连同内容一并输入到屏幕上
public class Homework02 {
    public static void main(String[] args) throws IOException {
         String filepath = "IO_HSP\\homework\\homework02\\hello.txt";
         BufferedReader br = null;
         String line = null;
         try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"gbk"));
            int i = 1;
            while((line = br.readLine()) != null){
                System.out.print(i+++" ");
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            br.close();
            
        }
         
    }
}
