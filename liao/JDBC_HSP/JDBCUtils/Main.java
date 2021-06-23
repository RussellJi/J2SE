package JDBC_HSP.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {

    }
    @Test
    public void test(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update admin set password = ? where name = ?; ";
        try {
            conn = JDBCUtilDruid.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "123abcd");
            pstmt.setString(2,"jhh");
            int row = pstmt.executeUpdate();
            if(row>0){
                System.out.println("修改成功！");
            }else{
                System.out.println("修改失败！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }finally{
            JDBCUtil.close(null, pstmt, conn);
        }
    }
    @Test
    //土法完成ResultSet的封装
    public void selectToArrayList(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "select * from user";
        ArrayList<User> array = new ArrayList<User>();
        try {
            conn = JDBCUtilDruid.getConnection();
            pstmt = conn.prepareStatement(sql);
            ResultSet set = pstmt.executeQuery();
            while(set.next()){
                array.add(new User(set.getString("name"), set.getInt("id"), set.getInt("age")));
            }
            for(User a : array){
                System.out.println(a);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }finally{
            JDBCUtil.close(null, pstmt, conn);
        }
    }


    /**
     * query源码分析
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh,
            Object... params) throws SQLException {

        PreparedStatement stmt = null;  //创建预处理对象
        ResultSet rs = null;
        T result = null;

        try {
            stmt = this.prepareStatement(conn, sql);
            this.fillStatement(stmt, params);  //将参数填充至preparedstatement中
            rs = this.wrap(stmt.executeQuery()); //通过反射进行封装
            result = rsh.handle(rs);       //结果集对象为ArrayLIst类型

        } catch (SQLException e) {
            this.rethrow(e, sql, params);

        } finally {
            try {
                close(rs);
            } finally {
                close(stmt);
            }
        }

        return result;
    }
     */

    @Test
    //Apache JDBCUtils
    public void commonTestQuery(){
        Connection conn = null;
        String sql = "select * from user";
        try {
            conn = JDBCUtilDruid.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            
            /**
             * queryRunner.query的参数
             * 1.conn连接对象
             * 2.sql语句
             * 3.new BeanListHandler<>(User.class)底层通过反射查看user有什么属性
             * 4.可变参数，给sql中的问号赋值
             * 
             * 底层会关闭resultset和statement
             */
            List<User> list = queryRunner.query(conn,sql,new BeanListHandler<>(User.class));

            for(User a : list){
                System.out.println(a);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }finally{
            JDBCUtil.close(null, null, conn);
        }
    }
    
    @Test
    //Apache JDBCUtils
    public void commonTestDelete(){
        Connection conn = null;
        String sql = "delete from user where name = ?";
        try {
            conn = JDBCUtilDruid.getConnection();
            // org.apache.commons.dbutils.QueryRunner
            QueryRunner queryRunner = new QueryRunner();
            
            /**
             * queryRunner.update的参数
             * 1.conn连接对象
             * 2.sql语句
             * 3.可变参数，给sql中的问号赋值
             * 
             * 底层会关闭resultset和statement
             */
            int num = queryRunner.update(conn, sql, "纪浩瀚");
            if (num>0){
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            JDBCUtil.close(null, null, conn);
        }
    }
    @Test
    //Apache JDBCUtils
    public void commonTestInsert(){
        Connection conn = null;
        String sql = "Insert into user(name,age) value('纪浩瀚',23);";
        try {
            conn = JDBCUtilDruid.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            
            /**
             * queryRunner.update的参数
             * 1.conn连接对象
             * 2.sql语句
             * 3.可变参数，给sql中的问号赋值
             * 
             * 底层会关闭resultset和statement
             */
            int num = queryRunner.update(conn, sql);
            if (num>0){
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            JDBCUtil.close(null, null, conn);
        }
    } 
    @Test
    //Apache JDBCUtils
    public void commonTestUpdate(){
        Connection conn = null;
        String sql = "Update user set id=116 where name='纪浩瀚';";
        try {
            conn = JDBCUtilDruid.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            
            /**
             * queryRunner.update的参数
             * 1.conn连接对象
             * 2.sql语句
             * 3.可变参数，给sql中的问号赋值
             * 
             * 底层会关闭resultset和statement
             */
            int num = queryRunner.update(conn, sql);
            if (num>0){
                System.out.println("修改成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            JDBCUtil.close(null, null, conn);
        }
    }


}


