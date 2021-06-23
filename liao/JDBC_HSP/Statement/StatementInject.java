package JDBC_HSP.Statement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.junit.Test;

public class StatementInject {
    @Test
    public void statementInject() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException{
        Properties props = new Properties();
        props.load(new FileReader("F:\\Vscode\\JavaProject\\J2SE\\liao\\JDBC_HSP\\Statement\\props.properties"));
        String driver = props.getProperty("driver");
        String url = props.getProperty("url");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,props);
        Statement stmt = conn.createStatement();
        System.out.println(conn.toString());
        Scanner sc = new Scanner(System.in);
        //why not next:因为next读到空格就返回结果了，nextLine()为读到换行符才返回结果
        System.out.println("请输入name:");
        String name = sc.nextLine();
        System.out.println("请输入password:");
        String password = sc.nextLine();


        // sql注入  name : " 1' or "; password = " or '1' = '1 ";
        // ResultSet set = stmt.executeQuery("select * from admin where name= '1' or 'and password ='or '1' = '1';");

        // sql语句中的引号不能省略
        ResultSet set = stmt.executeQuery("select * from admin where name='"+name+"' and password = '"+password+"';");
        if(set.next()){
            System.out.println("success");
            String n = set.getString(1);
            String p = set.getString(2);
            System.out.println(n+p);
        }
        // if(stmt.executeQuery("select * from admin where name = "+name+"and password = "+password).next()){
        //     System.out.println("登录成功！");
        // }else{
        //     System.out.println("登录失败！");
        // }
        stmt.close();
        conn.close();
    }
}
