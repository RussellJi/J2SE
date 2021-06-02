package IO_HSP.File;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("all")
public class DirectoryOperation {
    public static void main(String[] args) {
     
        // m1();
        m2();
        // m3();
    }
    public static void m1(){
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\File\\file2.txt";
        File file2 = new File(filepath);
        if(file2.exists()){
            System.out.println("文件存在！");
            if(file2.delete()){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }
        }else{
            System.out.println("文件不存在！");
            try {
                file2.createNewFile();
                System.out.println("创建成功！");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static void m2(){
        String dirpath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\File\\file";
        File dir = new File(dirpath);
        if(dir.exists()){
            System.out.println("目录存在！");
            if(dir.delete()){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }
        }else{
            System.out.println("目录不存在！");
            
        }
    }     
    public static void m3(){
        String dirpath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\File\\file";
        File dir = new File(dirpath);
        if(dir.exists()){
            System.out.println("目录存在！");
            if(dir.delete()){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }
        }else{
            System.out.println("目录不存在！");
            dir.mkdirs();
            System.out.println("目录创建成功！");
            
        }
    }     
}
