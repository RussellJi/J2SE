package JDBC_HSP.dao_.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * Druid工具类获取连接
 * 
 * 
 */
public class JDBCUtilDruid {
    public static final DataSource ds;
    //静态代码块读取props文件，并创建数据源对象
    static {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("F:\\Vscode\\JavaProject\\J2SE\\liao\\JDBC_HSP\\JDBCUtils\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        Connection conn;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
        return conn;
    }
    public static void close(ResultSet set, Statement stat, Connection conn){
        try {
            if(set!=null){
                set.close();
            }
            if(stat!=null){
                stat.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }

    }
}
