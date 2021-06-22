package JDBC_HSP.dataSource;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.junit.Test;

public class C3p0Test {
    @Test
    public void c3p0test() throws SQLException {
        //创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("jhh_DS");
        System.out.println("开始执行...");
        long start = System.currentTimeMillis();
        for(int i = 0; i<500000; i++){
            Connection conn = comboPooledDataSource.getConnection();
            // System.out.println("连接ok");
            conn.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0连接mysql500000 耗时："+(end - start));
    }
}
