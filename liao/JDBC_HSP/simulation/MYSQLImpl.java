package JDBC_HSP.simulation;

public class MYSQLImpl implements JDBCInterface{


    @Override
    public void connection() {
        System.out.println("连接到mysql数据库！");        
    }

    @Override
    public void crud() {
        System.out.println("mysql数据库的CRUD！");        
    }

    @Override
    public void close() {
        System.out.println("关闭mysql的连接！");        
    }
    
}
