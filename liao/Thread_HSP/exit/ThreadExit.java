package Thread_HSP.exit;

import java.util.Scanner;

public class ThreadExit {
    public static void main(String[] args) {
        T1 t = new T1();
        t.start();

        // 手动让线程退出，改变while(flag)
        Scanner sc = new Scanner(System.in);
        if(sc.nextLine().equals("quit")){
            t.setFlag(false);
        }



    }
}

class T1 extends Thread {
    private boolean flag = true;
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(flag){
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}