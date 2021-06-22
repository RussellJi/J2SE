package JDBC_HSP.JDBCUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBCUtils
 * 1.创建连接
 * 3.释放资源,关闭连接
 */

public class JDBCUtil {
    static Properties props;
    static String driver;
    static String url;
    static{
        props = new Properties();
        try {
            props.load(new FileInputStream("F:\\Vscode\\JavaProject\\J2SE\\liao\\JDBC_HSP\\JDBCUtils\\props.properties"));
            driver = props.getProperty("Driver");
            url = props.getProperty("url");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
        
    }
    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(url,props);
            return conn;
        } catch (SQLException e) {
            // 将编译异常，作为运行异常抛出，开发人员既可以捕获，也可以按默认处理
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet set, Statement stmt, Connection conn){
        try {
            if(set != null){
                set.close();
            }
            if(stmt!=null){
                stmt.close();
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
