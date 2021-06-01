package Thread_HSP.exit;

public class ThreadExit {
    public static void main(String[] args) {
        T1 t = new T1();
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t.setFlag(false);
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