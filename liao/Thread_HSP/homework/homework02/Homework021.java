package Thread_HSP.homework.homework02;


/**
 * 转账问题
 * 1.创建三个线程同时取钱
 * 2.若不加锁
 *   假如余额有1000时，当三个线程同时余额时，还可以取一次，很有可能取三次
 * 3.必须加锁
 *   在哪加锁：查看余额+取钱
 *      
 */
public class Homework021 {
    public static void main(String[] args) {
        T t = new T();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();

    }
}
class T implements Runnable{
    int salary = 10000;
    public static Object o = new Object();
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Thread.yield();
            synchronized (o){
                if(salary<1000){
                    System.out.println("余额不足");
                    // try {
                    //     Thread.sleep(1000);
                    // } catch (InterruptedException e) {
                    //     // TODO Auto-generated catch block
                    //     e.printStackTrace();
                    // }
                    break;
                }else{
                    getMoney();
                }
            }
            
        }
        
    }
    void getMoney(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 失败：原因，三个线程查看余额后还有1000，同步执行最后一次的取钱，还是会出现问题，应在查看+取钱的地方加锁
        // synchronized(o){
        //     System.out.println(Thread.currentThread().getName()+"取出了1000，还剩："+(salary-=1000));
        // }
        System.out.println(Thread.currentThread().getName()+"取出了1000，还剩："+(salary-=1000));
    }
}