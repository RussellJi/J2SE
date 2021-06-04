package IO_HSP.standard;

public class InAndOut {
    public static void main(String[] args) {
        // 编译类型 public static final InputStream in = null;
        // 运行类型 Class java.io.BufferedInputStream
        // 键盘
        System.out.println(System.in.getClass());

        // 编译类型 public static final PrintStream out = null;
        // 运行类型 class java.io.PrintStream
        // 显示器
        System.out.println(System.out.getClass());
        
    }
}
