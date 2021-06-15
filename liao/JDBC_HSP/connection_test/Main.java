package JDBC_HSP.connection_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

import org.junit.Test;

import java.util.Properties;
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) throws SQLException {

    } 
    @Test
    public void connect1() throws SQLException{
        // 第一种连接
        /**
         * 1.注册驱动 import com.mysql.jdbc.Driver;
         * 2.获取连接对象
         */
        Driver driver = new Driver();
        String url = "JDBC:mysql://localhost:3306/jhh_jdbc";
        Properties props = new Properties();
        props.put("user","root");
        props.put("password","123456");
        Connection connect = driver.connect(url, props);
        System.out.println("连接1："+connect);
        connect.close();
    }
    @Test
    public void connect2() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
        // 第二种连接（运行时动态加载类）
        /**
         * 1.利用反射在运行时动态获取驱动实现类Driver;
         * 2.获取连接对象;
         */

        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)clazz.newInstance();
        String url = "JDBC:mysql://localhost:3306/jhh_jdbc";
        Properties props = new Properties();
        props.put("user","root");
        props.put("password","123456");
        Connection connect = driver.connect(url, props);
        System.out.println("连接2："+connect);
        connect.close();
    }
    @Test
    public void connect3() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
        // 第三种连接（用DriverManager替换Driver）
        /**
         * 1.利用反射在运行时动态获取驱动实现类Driver;
         * 2.获取连接对象;
         */

        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)clazz.newInstance();
        String url = "JDBC:mysql://localhost:3306/jhh_jdbc";
        Properties props = new Properties();
        props.put("user","root");
        props.put("password","123456");
        DriverManager.registerDriver(driver);
        Connection connect = DriverManager.getConnection(url, props);
        System.out.println("连接3："+connect);
        connect.close();
    }
    @Test
    public void connect4() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
        // 第四种连接（自动注册Driver）
        /**
         * 1.利用反射在运行时动态获取驱动实现类Driver;
         * 2.获取连接对象;
         */
        // 底层有static{}帮我们做了驱动注册
        Class.forName("com.mysql.jdbc.Driver");
 
        // Driver driver = (Driver)clazz.newInstance();
        String url = "JDBC:mysql://localhost:3306/jhh_jdbc";
        Properties props = new Properties();
        props.put("user","root");
        props.put("password","123456");
        // DriverManager.registerDriver(driver);
        Connection connect = DriverManager.getConnection(url, props);
        System.out.println("连接4："+connect);
        connect.close();
    }

    @Test
    public void connect5() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, FileNotFoundException, IOException{
        // 第五种连接（将用户密码url写入配置文件中）
        /**
         * 1.利用反射在运行时动态获取驱动实现类Driver;
         * 2.获取连接对象;
         */
        
        Properties props = new Properties();
        props.load(new FileInputStream("F:\\Vscode\\JavaProject\\J2SE\\liao\\JDBC_HSP\\connection_test\\props.properties"));
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String url = props.getProperty("url");
        String driver = props.getProperty("driver");
        Class.forName(driver);
        // DriverManager.registerDriver(driver);
        Connection connect = DriverManager.getConnection(url, props);
        System.out.println("连接5："+connect);
        connect.close();
    }
    
    

}
