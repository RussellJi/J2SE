package IO_HSP.File;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("all")
public class FileCreate {
    public static void main(String[] args) {
        create01();
        create02();
        create03();
    }

    public static void create01(){
        String pathname = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\File\\file1.txt";
        File file1 = new File(pathname);
        try {
            file1.createNewFile();
            System.out.println("file1创建成功！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void create02(){
        String parent = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\File\\";
        String child = "file2.txt";
        File file2 = new File(parent, child);
        try {
            file2.createNewFile();
            System.out.println("file2创建成功！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void create03(){
        File parentfile = new File("F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\File\\");
        String child = "file3.txt";
        File file3 = new File(parentfile, child);
        try {
            file3.createNewFile();
            System.out.println("file3创建成功！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
