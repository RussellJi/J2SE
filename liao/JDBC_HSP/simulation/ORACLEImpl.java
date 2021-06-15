package JDBC_HSP.simulation;

public class ORACLEImpl implements JDBCInterface{


    @Override
    public void connection() {
        System.out.println("连接到Oracle数据库！");        
    }

    @Override
    public void crud() {
        System.out.println("Oracle数据库的CRUD！");        
    }

    @Override
    public void close() {
        System.out.println("关闭Oracle的连接！");        
    }
    
}
