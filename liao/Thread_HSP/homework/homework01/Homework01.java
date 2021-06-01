package Thread_HSP.homework.homework01;

import java.util.Random;
import java.util.Scanner;

/**
 * 
（1）在main方法中启动两个线程;

（2）第1个线程循环随机打印100以内的整数;

 (3）直到第2个线程从键盘读取了“Q”命令.
 */

public class Homework01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}

class  T1 extends Thread{
    static boolean flag = true;
    @Override
    public void run() {
        // TODO Auto-generated method stub
        Random random = new Random();
        while (flag){
            // Math.random() 返回0,，1的double数
            int a = (int) (Math.random()*100);
            System.out.println(a);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("A线程退出!!!");
    }
    public void setFlag(boolean flag) {
        T1.flag = flag;
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            Scanner sc = new Scanner(System.in);
            if(sc.nextLine().charAt(0)=='q'){
                System.out.println("B线程退出！！！");
                // 用通知的方式，结束A线程
                T1.flag = false;
                break;
            }
        }
    }
}