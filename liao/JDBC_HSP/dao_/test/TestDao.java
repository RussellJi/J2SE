package JDBC_HSP.dao_.test;

import java.util.List;

import org.junit.Test;

import JDBC_HSP.dao_.dao.UserDao;
import JDBC_HSP.dao_.domain.User;

public class TestDao {
    @Test
    public void testUserDao(){
        UserDao userDao = new UserDao();

        //1.测试多行查询
        String sql1 = "select * from user where id > ?";
        List<User> list = userDao.queryMulti(sql1, User.class, 1);
        for(User user:list){
            System.out.println(user);
        }

        System.out.println("---------------------------------");

        // 2.测试单行查询
        String sql2 = "select * from user where id = ?";
        User user = userDao.querySingle(sql2, User.class, 116);
        System.out.println(user!=null ? user:"查询失败");

        System.out.println("---------------------------------");

        // 3.测试插入语句
        String sql3 = "insert into user(name,age) values(?,?)";
        int num = userDao.update(sql3, "张无忌","26");
        System.out.println(num > 0 ? "插入成功":"插入失败");

        System.out.println("---------------------------------");

        // 4.测试删除语句
        String sql4 = "delete from user where name = ?";
        int num2 = userDao.update(sql4, "张无忌");
        System.out.println(num > 0 ? "删除成功":"删除失败");

        System.out.println("---------------------------------");

        // 查询单个数据
        String sql5 = "select id from user where name = ?";
        int id = (int) userDao.queryScalar(sql5, User.class, "纪浩瀚");
        System.out.println(id);

    }
}
