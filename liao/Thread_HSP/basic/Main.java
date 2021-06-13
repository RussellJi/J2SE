package Thread_HSP.basic;


// 主线程每一秒打印汪，打印60次
// Miao线程每秒打印喵，打印80次
// 主线程先退出，Miao线程继续执行
// 可用Jconsole查看当前虚拟机中线程的状态
// 设定守护线程，工作线程结束之后，守护线程也就结束 setDaemon，设在start之前

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());  //获取核心数

        ThreadMiao thread = new ThreadMiao();
        // 设定thread为守护线程,主线程结束，thread也就结束
        thread.setDaemon(true);
        thread.start();
     

        System.out.println("主线程开始启动:"+Thread.currentThread().getName());  //main
        for(int i=0;i<5;i++){
            System.out.println("汪");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        System.out.println("主线程结束！");
        
    }
}