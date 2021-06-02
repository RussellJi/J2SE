package IO_HSP.File;

import java.io.File;


@SuppressWarnings("all")
public class FileInfo {
    public static void main(String[] args) {
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\File\\file1.txt";
        File file = new File(filepath);
        System.out.println("获取文件名："+file.getName());
        System.out.println("获取文件路径："+file.getPath());
        System.out.println("获取文件绝对路径："+file.getAbsolutePath());
        System.out.println("获取文件父目录："+file.getParent());
        System.out.println("获取文件大小："+file.length());
        System.out.println("文件是否存在："+file.exists());
        System.out.println("是否是文件："+file.isFile());
    }
}
