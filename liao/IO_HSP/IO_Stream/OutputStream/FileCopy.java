package IO_HSP.IO_Stream.OutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 文件的拷贝：
 * 1.创建输入流将文件读入java程序；
 * 2.创建输出流，将文件输出到指定的目录；
 * 注：不可将文件一次性读完再输出，万一文件比较大，容易造成内存不足
 */

 @SuppressWarnings("all")
public class FileCopy {
    public static void main(String[] args) throws IOException {
        // ArrayList list;
        // list = readFile();
        // writeFile(list);
        copyFile();
    }
    public static ArrayList<Byte> readFile() throws IOException{
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\InputStream\\hello.txt";
        FileInputStream fis = null;
        ArrayList<Byte> list = null;
        try {
            fis = new FileInputStream(filepath);
            list = new ArrayList<Byte>();
           
            while((fis.read())!=-1){
                list.add((byte) (fis.read()));
            }
            System.out.println(list);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            fis.close();
            return list; 
        }
    }

    public static void writeFile(ArrayList list) throws IOException{
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\OutputStream\\hello.txt";
        FileOutputStream fos = null;
        Object[] b = null;
        try {
            fos = new FileOutputStream(filepath);
            Iterator it = list.iterator();
            b = list.toArray();
         
            System.out.println(b);
            for(int i = 0;i<b.length; i++){
                fos.write(((Byte)b[i]).byteValue());
            }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            fos.close();
        }
    }

    public static void copyFile() throws IOException{
        String srcfilepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\InputStream\\hello.txt";
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\OutputStream\\hello.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int dataLen = 0;
        byte[] b = new byte[1024];
        try {
            fis = new FileInputStream(srcfilepath);
            fos = new FileOutputStream(filepath);
            while((dataLen = fis.read(b)) != -1){
                fos.write(b, 0, dataLen);
            }
            System.out.println("文件拷贝成功！");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            fis.close();
            fos.close();
            
        }
    }
}
