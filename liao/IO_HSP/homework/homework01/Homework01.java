package IO_HSP.homework.homework01;

import java.io.File;
import java.io.IOException;

// 判断文件夹与文件是否存在，不存在则创建

public class Homework01 {
    public static void main(String[] args) {
        String dirpath = "IO_HSP\\homework\\homework01\\mytemp";
        File file = new File(dirpath);
        if(!file.exists()){
            file.mkdirs();
            System.out.println("mytemp创建成功！");
        }else{
            System.out.println("文件夹已经存在");
        }
        String filepath = "IO_HSP\\homework\\homework01\\mytemp\\hello.txt";
        File file2 = new File(filepath);
        if(!file2.exists()){
            try {
                file2.createNewFile();
                System.out.println("hello.txt创建成功");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            System.out.println("文件已经存在");

        }
        
        
    }
}
