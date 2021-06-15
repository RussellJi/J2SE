package JDBC_HSP.simulation;

public class Main {
    public static void main(String[] args) {
        JDBCInterface mysql = new MYSQLImpl();
        mysql.connection();
        mysql.crud();
        mysql.close();

        System.out.println("---------");
        JDBCInterface oracle = new ORACLEImpl();
        oracle.connection();
        oracle.crud();
        oracle.close();
    }
}
