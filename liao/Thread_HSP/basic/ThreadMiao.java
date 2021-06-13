package Thread_HSP.basic;

public class ThreadMiao extends Thread{
    static int count = 0;
    @Override
    public void run() {

        // TODO Auto-generated method stub
        // super.run();

        System.out.println("子线程开始启动:"+Thread.currentThread().getName()); //Thread-0

        while(true){
            if(count == 10){
                return;
            }
            System.out.println("喵");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            count+=1;
        }
    }
}