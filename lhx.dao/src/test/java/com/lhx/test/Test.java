package com.lhx.test;

import com.lhx.dao.AvatarDao;
import com.lhx.dao.UserDao;
import com.lhx.model.Avatar;
import com.lhx.model.User;
import com.lhx.util.JdbcUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lhx on 15-1-12 上午11:20
 *
 * @project multiMavenWeb
 * @package com.lhx.test
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class Test {

    private UserDao userDao ;
    private AvatarDao avatarDao ;

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        userDao = (UserDao) context.getBean("userDao");
        avatarDao = (AvatarDao) context.getBean("avatarDao");
    }

    @org.junit.Test
    public void testInsert(){
        User user = new User();
        user.setId(3);
        user.setNickname("新");
        user.setState(5);
        userDao.insertUser(user) ;
    }

    @org.junit.Test
    public void testInsert2(){
        User user = new User();
        user.setNickname("新");
        user.setState(5);
        userDao.insertUserBackID(user) ;
        //插入数据后，会自动填充ID
        System.out.println(user.getId());
    }

    
    @org.junit.Test
    public void testGetAvatars() throws SQLException {
        //本地数据库数据总条数
        int sum = 6177456 ;
        Connection connection = JdbcUtils.getConnection("jdbc:mysql://192.168.2.3/nyx", "skst", "TestDBSkst$@");
        String sql = "insert into account_photo(accountId,path,status,createTime) values (?,?,?,?)" ;
        PreparedStatement pstmt = connection.prepareStatement(sql) ;
        //每次获取20000条，执行插入操作
        for (int i = 0; i < sum; i = i+20000) {
            int start = i ;
            int limit = 20000 ;

            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("start",start);
            map.put("limit",limit);
            List<Avatar> avatars = avatarDao.getAvatar(map);
            for (Avatar avatar : avatars) {
                String photo_path = avatar.getAvatarsPath();
                //过滤不合格的照片路径
                if (!photo_path.equals("02/MjAxNDA0MjcxMjQ0MTBfMTE4LjI0NC4yNTUuMTExXzc2MjExOA==.jpg")&&
                        !photo_path.equals("male.jpg") && !photo_path.equals("female.jpg")&&!photo_path.equals("sharehead.jpg")){

                    //用户accountId
                    pstmt.setLong(1,avatar.getAccountId());
                    //照片路径
                    pstmt.setString(2,photo_path);
                    //已通过审核的状态
                    pstmt.setInt(3,1);
                    //插入日期，原数据库没有日期，统一为插入数据的日期
                    pstmt.setDate(4,new Date(System.currentTimeMillis()));
                    pstmt.execute();
                }
            }
            //打印执行条数
            System.out.println(start + limit);
        }
        //释放链接资源
        JdbcUtils.free(null,pstmt,connection);
    }
}
