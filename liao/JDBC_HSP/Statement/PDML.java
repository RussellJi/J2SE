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

public class PDML {
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
        String sql_i = "insert into admin values(?,?);";

        //注意？的先后顺序
        String sql_u = "update admin set password = ? where name = ? ;";

        // 注意conn.prepareStatement
        PreparedStatement pstmt = conn.prepareStatement(sql_i);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入name:");
        pstmt.setString(1,sc.nextLine());
        System.out.println("请输入password:");
        pstmt.setString(2, sc.nextLine());
        sc.close();

        int rows = pstmt.executeUpdate();
        if(rows > 0){
            System.out.println("操作成功！");
        }else{
            System.out.println("操作失败！");
        }

        String sql_q = "select * from admin;";
        PreparedStatement pstmt2 = conn.prepareStatement(sql_q);
        ResultSet set2 = pstmt2.executeQuery();

        while(set2.next()){
            String name = set2.getString(1);
            String password = set2.getString(2);
            System.out.println(name+":"+password);
        }
        pstmt.close();
        conn.close();
    }
}
