package JDBC_HSP.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        selectToArrayList();
    }
    // @Test
    public static void test(){
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
    // @Test
    public static void selectToArrayList(){
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


}


