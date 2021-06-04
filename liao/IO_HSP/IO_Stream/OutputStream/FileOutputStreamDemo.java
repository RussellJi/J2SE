package IO_HSP.IO_Stream.OutputStream;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * data 转为 byte[]
 * new FileOutputStream(path,true)可实现追加
 */

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        WriteFile02();
    }

    public static void WriteFile01() throws IOException{
        String data = "纪浩瀚";
        FileOutputStream fos = null;
        try {
            String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\InputStream\\hello.txt";
            fos = new FileOutputStream(filepath);
            byte[] b = data.getBytes("UTF-8");
            System.out.println(data.length());
            fos.write(b);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            fos.close();
        }
    }

    public static void WriteFile02() throws IOException{
        String data = "纪浩瀚";
        FileOutputStream fos = null;
        try {
            String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\OutputStream\\hello.txt";
            fos = new FileOutputStream(filepath,true);
            byte[] b = data.getBytes("UTF-8");
            System.out.println(data.length());
            // 写入指定字节数组的指定位置开始的指定长度的数据
            fos.write(b,6,3);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            fos.close();
        }
    }

    public static void WriteFile03() throws IOException{
        String data = "张书嫚";
        FileOutputStream fos = null;
        try {
            String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\InputStream\\hello.txt";
            // true 追加
            fos = new FileOutputStream(filepath,true);
            byte[] b = data.getBytes("UTF-8");
            System.out.println(data.length());
            fos.write(b);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            fos.close();
        }
    }
}
