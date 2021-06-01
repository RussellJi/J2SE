package Thread_HSP.ticket;

public class Main {
    public static void main(String[] args) {
        Thread_ticket04 ticket = new Thread_ticket04();
        // Thread_Ticket Ticket = new Thread_Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start(); 


    }
}
