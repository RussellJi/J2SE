package Thread_HSP.deadlock;

public class DeadLock extends Thread{
    private static Object o1 = new Object();
    private static Object o2 = new Object(); 
    boolean flag = true;
    DeadLock(boolean flag){
        this.flag = flag;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        if(flag){
            synchronized(o1){
                System.out.println(Thread.currentThread().getName()+"进入了1通道");
                synchronized(o2){
                    System.out.println(Thread.currentThread().getName()+"进入了2通道");
                }
            }
        }else{
            synchronized(o2){
                System.out.println(Thread.currentThread().getName()+"进入了2通道");
                synchronized(o1){
                    System.out.println(Thread.currentThread().getName()+"进入了1通道");
                }
            }
        }
        
    }
}
