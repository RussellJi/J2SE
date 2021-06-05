package IO_HSP.IO_Stream.standard;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class InAndOut {
    public static void main(String[] args) throws IOException {
        // 编译类型 public static final InputStream in = null;
        // 运行类型 Class java.io.BufferedInputStream
        // 键盘
        System.out.println(System.in.getClass());

        // 编译类型 public static final PrintStream out = null;
        // 运行类型 class java.io.PrintStream
        // 显示器
        System.out.println(System.out.getClass());

        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\standard\\out.txt";
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(filepath));
            // out = System.out;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println("hello zsm");
        out.write("hello jhh".getBytes());
        out.close();

        System.setOut(new PrintStream(new FileOutputStream(filepath,true)));
        System.out.println("\r\nhello");

        PrintWriter out2 = null;
        out2 = new PrintWriter(new FileWriter(filepath,true));
        out2.println("hello zsm");
        out2.write("welcome to QHD");
        out2.close();
        

        
    }
}
