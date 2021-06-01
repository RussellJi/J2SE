package Thread_HSP.thread_state;

/**
 * 查看线程的状态
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName()+":"+t.getState());
        t.start();
        while(Thread.State.TERMINATED != t.getState()){
            System.out.println(t.getName()+":"+t.getState());
            Thread.sleep(300);
        }
        System.out.println(t.getName()+":"+t.getState());
    }
}

class T extends Thread {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true){
            for(int i = 0;i<10;i++){
                System.out.println("hi"+i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            break;
        }
    }
}