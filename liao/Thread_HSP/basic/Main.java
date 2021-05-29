package Thread_HSP.basic;


@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());  //4

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
