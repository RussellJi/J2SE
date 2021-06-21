package JDBC_HSP.dataSource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import org.junit.Test;

public class DruidTest {
    @Test
    public void druidTest() throws Exception{
        Properties props = new Properties();
        props.load(new FileInputStream("F:\\Vscode\\JavaProject\\J2SE\\liao\\JDBC_HSP\\dataSource\\druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(props);
        long startTime = System.currentTimeMillis();
        for(int i=0; i<5000; i++){
            Connection conn = ds.getConnection();
            // System.out.println("连接ok");
            conn.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("druid 连接5000次 耗时:"+(endTime - startTime));
    }
}
