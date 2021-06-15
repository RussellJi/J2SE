package JDBC_HSP.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



import org.junit.Test;

public class Exercise {
    /**
     * 1.创建news表
     * 2.使用JDBC添加5条数据
     * 3.修改id = 1的记录，将name改成自己的名字
     * 4.删除id = 3的记录
     * @throws SQLException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    @Test
    public void exercise() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
        Properties props = new Properties();
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\JDBC_HSP\\connection_test\\props.properties";
        props.load(new FileInputStream(filepath));
        String driver = props.getProperty("driver");
        String url = props.getProperty("url");
        // 自动注册驱动
        Class.forName(driver);
        // 获取连接对象
        Connection conn = DriverManager.getConnection(url,props);
        // 获取sql执行对象
        Statement stmt = conn.createStatement();
        // 创建news表
        stmt.execute("create table if not exists news(id int NOT NULL PRIMARY KEY AUTO_INCREMENT, name varchar(20));");
        //插入5条记录
        for(int i=0;i<5;i++){
            stmt.executeUpdate("insert into news(name)values("+i+")");
        }
        ResultSet resultSet = stmt.executeQuery("select * from news");
        while(resultSet.next() == true){
            System.out.println("id:"+resultSet.getInt(1));
            System.out.println("name:"+resultSet.getString(2));
        }
        // 修改id为1的name为纪浩瀚
        int num = stmt.executeUpdate("update news set name = '纪浩瀚' where id = 3;");
        System.out.println(num);
        // 删除id = 3的记录
        num = stmt.executeUpdate("delete from news where id = 5; ");
        System.out.println(num);
        resultSet = stmt.executeQuery("select * from news");
        while(resultSet.next() == true){
            System.out.println("id:"+resultSet.getInt(1));
            System.out.println("name:"+resultSet.getString(2));
        }
        stmt.close();
        conn.close();

    }
}
