package Thread_HSP.ticket;

public class Thread_ticket implements Runnable{
    private int count = 30;

    //同步机制,在任意时刻，只能有一个线程在卖票
    // 注：不能在run方法前加synchronized，否则只能单线程卖票
    @Override
    public void run() {
        // TODO Auto-generated method stub

        while (true) {
            if(count<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"卖出了一张票，还剩"+(--count)+"张票");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    
    
}

class Thread_ticket02 extends Thread{
    private static int count = 30;

    //同步机制,在任意时刻，只能有一个线程在卖票
    @Override
    public synchronized void run() {
        // TODO Auto-generated method stub
        while (true) {
            if(count<=0){
                break;
            }
           
            System.out.println(Thread.currentThread().getName()+"卖出了一张票，还剩"+(--count)+"张票");
        }

    }
    
}

class Thread_ticket03 implements Runnable{
    private int count = 30;
    private boolean flag = true;
    //同步机制,在任意时刻，只能有一个线程在卖票
    // 注：不能在run方法前加synchronized，否则只能单线程卖票
    @Override
    public void run() {
        // TODO Auto-generated method stub

        while (flag) {
            try {
                int sig = task();
                if(sig==0){
                    break;
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }

    public synchronized int task() throws InterruptedException{
        int sig = 1;
        if(count==0){
            // sig = 0;
            flag = false;
            System.out.println("售票结束，下次再来");
            return sig;
        }
        System.out.println(Thread.currentThread().getName()+"卖出了一张票，还剩"+(--count)+"张票");
        Thread.sleep(100);
        return sig;
    }

    
    
}