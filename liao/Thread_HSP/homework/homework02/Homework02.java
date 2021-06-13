package Thread_HSP.homework.homework02;


/**
（1）有2个用户分别从同一个卡上取钱（总额：10000）

（2）每次都取1000，当余额不足时，就不能取款了

（3）不能出现超取现象，线程同步问题

 */
public class Homework02 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}

class Card {
    public static int salary = 10000;
    public static int setSalary(){
        
            // try {
            //     Thread.sleep(1000);
            // } catch (InterruptedException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }
        synchronized(Card.class){
            if(salary>=1000){
                Card.salary-=1000;
            }else{
                System.out.println("余额不足");
            }
            return Card.salary;
        }
    }
    public static int getSalary(){
        return salary;
    }

}

class T1 extends Thread {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            // if(Card.getSalary()<1000){
            //     System.out.println("余额不足");
            //     break;
            // }
            int s = Card.setSalary();
            System.out.println(Thread.currentThread().getName()+"取出了1000，还剩"+s);
            if(s < 1000){
                break;
            }
           
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            // if(Card.getSalary()<1000){
            //     System.out.println("余额不足");
            //     break;
            // }
            int s = Card.setSalary();
            System.out.println(Thread.currentThread().getName()+"取出了1000，还剩"+s);
            if(s < 1000){
                System.out.println();
                break;
            }
        }
    }
}