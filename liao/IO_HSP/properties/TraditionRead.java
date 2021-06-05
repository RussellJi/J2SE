package IO_HSP.properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TraditionRead {
    public static void main(String[] args) {
        String filepath = "IO_HSP\\properties\\info.properties";
        // 用字符流读取文本文件
        BufferedReader br = null;
        String line =  null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            try {
                while((line = br.readLine())!=null){
                    String[] l = line.split("=");
                    
                    System.out.println(l[0].trim()+":"+l[1].trim());
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
