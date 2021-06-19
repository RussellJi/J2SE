package JDBC_HSP.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update admin set password = ? where name = ?; ";
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "123abc");
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
}
