package Thread_HSP.basic;


// 主线程每一秒打印汪，打印60次
// Miao线程每秒打印喵，打印80次
// 主线程先退出，Miao线程继续执行
// 可用Jconsole查看当前虚拟机中线程的状态

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());  //

        ThreadMiao thread = new ThreadMiao();
        
        thread.start();

        System.out.println("主线程开始启动:"+Thread.currentThread().getName());  //main
        for(int i=0;i<60;i++){
            System.out.println("汪");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
    }
}