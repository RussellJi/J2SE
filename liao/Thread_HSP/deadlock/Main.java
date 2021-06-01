package Thread_HSP.deadlock;

public class Main {
    public static void main(String[] args) {
        DeadLock d1 = new DeadLock(true);
        DeadLock d2 = new DeadLock(false);
        d2.start();
        d1.start();
        
        

    }
}
