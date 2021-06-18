package JDBC_HSP.Statement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;
import java.util.Scanner;

public class PQuery {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
        test();
    }
    public static void test() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        Properties props = new Properties();
        props.load(new FileInputStream("F:\\Vscode\\JavaProject\\J2SE\\liao\\JDBC_HSP\\Statement\\props.properties"));
        String driver = props.getProperty("driver");
        String url = props.getProperty("url");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,props);
        String sql = "SELECT * from admin where name = ? and password = ? ;";

        // 注意conn.prepareStatement
        PreparedStatement pstmt = conn.prepareStatement(sql);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入name:");
        pstmt.setString(1,sc.nextLine());
        System.out.println("请输入password:");
        pstmt.setString(2, sc.nextLine());
        sc.close();

        ResultSet set = pstmt.executeQuery();
        if(set.next()){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
        pstmt.close();
        conn.close();
    }
}
