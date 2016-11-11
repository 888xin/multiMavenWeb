package com.lhx.test;

import com.lhx.dao.AvatarDao;
import com.lhx.dao.DashboardDao;
import com.lhx.dao.DashboardIdDao;
import com.lhx.dao.UserDao;
import com.lhx.model.Avatar;
import com.lhx.model.Dashboard;
import com.lhx.model.DashboardId;
import com.lhx.model.User;
import com.lhx.util.JdbcUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private DashboardIdDao dashboardIdDao ;
    private DashboardDao dashboardDao ;

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        userDao = (UserDao) context.getBean("userDao");
        avatarDao = (AvatarDao) context.getBean("avatarDao");
        dashboardIdDao = (DashboardIdDao) context.getBean("dashboardIdDao");
        dashboardDao = (DashboardDao) context.getBean("dashboardDao");
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



    @org.junit.Test
    public void testAvatars() throws SQLException {
        //本地数据库数据总条数
        int sum = 6177456 ;
        //待存入数据的数据库连接信息
        Connection connection = JdbcUtils.getConnection("jdbc:mysql://192.168.2.3/nyx", "skst", "TestDBSkst$@");
        StringBuilder stringBuilder = new StringBuilder();
        Statement statement = connection.createStatement();
        //每次获取20000条，执行插入操作
        for (int i = 0; i < sum; i = i+500000) {
            int start = i ;
            int limit = 500000 ;

            stringBuilder.append("insert into account_photo(accountId,path,status,createTime) values ");
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("start",start);
            map.put("limit",limit);
            List<Avatar> avatars = avatarDao.getAvatar(map);
            Date date = new Date(System.currentTimeMillis());
            for (Avatar avatar : avatars) {
                String photo_path = avatar.getAvatarsPath();
                //过滤不合格的照片路径
                if (!photo_path.equals("02/MjAxNDA0MjcxMjQ0MTBfMTE4LjI0NC4yNTUuMTExXzc2MjExOA==.jpg")&&
                        !photo_path.equals("male.jpg") && !photo_path.equals("female.jpg")&&!photo_path.equals("sharehead.jpg")){

                    stringBuilder.append("(");
                    //用户accountId
                    stringBuilder.append(avatar.getAccountId()+",");
                    //照片路径
                    stringBuilder.append("'" + photo_path+"',");
                    //已通过审核的状态
                    stringBuilder.append(1+",");
                    //插入日期，原数据库没有日期，统一为插入数据的日期
                    stringBuilder.append("'" + date+"'),");

                }
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            stringBuilder.append(";");
            statement.executeUpdate(stringBuilder.toString());
            stringBuilder.setLength(0);
            //打印执行条数
            System.out.println(start + limit);
        }
        //释放链接资源
        JdbcUtils.free(null,statement,connection);
    }

    @org.junit.Test
    public void testAvatars2() throws SQLException {
        //本地数据库数据总条数
        int sum = 6177456 ;
//        int sum = 6 ;
        //待存入数据的数据库连接信息
        Connection connection = JdbcUtils.getConnection("jdbc:mysql://192.168.2.3/nyx", "skst", "TestDBSkst$@");
        StringBuilder stringBuilder = new StringBuilder();
        Statement statement = connection.createStatement();
        //开始的ID
        Long start = null ;
        //每次获取20000条，执行插入操作
        for (int i = 0; i < sum; i = i+500000) {
            int limit = 500000 ;
            stringBuilder.append("insert into account_photo(accountId,path,status,createTime) values ");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start",start);
            map.put("limit",limit);
            List<Avatar> avatars = avatarDao.getAvatar2(map);
            Date date = new Date(System.currentTimeMillis());
            for (Avatar avatar : avatars) {
                String photo_path = avatar.getAvatarsPath();
                //过滤不合格的照片路径
                if (!photo_path.equals("02/MjAxNDA0MjcxMjQ0MTBfMTE4LjI0NC4yNTUuMTExXzc2MjExOA==.jpg")&&
                        !photo_path.equals("male.jpg") && !photo_path.equals("female.jpg")&&!photo_path.equals("sharehead.jpg")){

                    stringBuilder.append("(");
                    //用户accountId
                    stringBuilder.append(avatar.getAccountId()+",");
                    //照片路径
                    stringBuilder.append("'" + photo_path+"',");
                    //已通过审核的状态
                    stringBuilder.append(1+",");
                    //插入日期，原数据库没有日期，统一为插入数据的日期
                    stringBuilder.append("'" + date+"'),");
                }
                start = avatar.getAvatarsId();
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            stringBuilder.append(";");
            statement.executeUpdate(stringBuilder.toString());
            stringBuilder.setLength(0);
            //打印执行条数
            System.out.println(i + limit);
        }
        //释放链接资源
        JdbcUtils.free(null,statement,connection);
    }

    @org.junit.Test
    public void test2(){
        String s1= "0.12";
        String s2 = s1.substring(0, s1.indexOf("."));
        System.out.println(Double.valueOf(s1).intValue());
    }

    @org.junit.Test
    public void test3(){
        DashboardId dashboardId = new DashboardId();
        dashboardIdDao.getDashboardId(dashboardId);
        System.out.println(dashboardId.getDashboardId());
    }

    @org.junit.Test
    public void test4(){
        try {
            JSONObject jsonObject = new JSONObject("{\"id\":\"z1.lifeix-live.960753\",\"createdAt\":\"2016-09-08T09:46:21.916+08:00\",\"updatedAt\":\"2016-09-30T16:25:29.410557745+08:00\",\"expireAt\":\"2016-10-15T18:44:54.372+08:00\",\"title\":\"960753\",\"hub\":\"lifeix-live\",\"disabledTill\":0,\"disabled\":false,\"publishKey\":\"715a90f39e2c5c4e\",\"publishSecurity\":\"static\",\"hosts\":{\"publish\":{\"rtmp\":\"pili-publish.live.l99.com\"},\"live\":{\"hdl\":\"pili-live-hdl.live.l99.com\",\"hls\":\"pili-live-hls.live.l99.com\",\"http\":\"pili-live-hls.live.l99.com\",\"rtmp\":\"pili-live-rtmp.live.l99.com\",\"snapshot\":\"pili-live-snapshot.live.l99.com\"},\"playback\":{\"hls\":\"10003g3.playback1.z1.pili.qiniucdn.com\",\"http\":\"10003g3.playback1.z1.pili.qiniucdn.com\"},\"play\":{\"http\":\"pili-live-hls.live.l99.com\",\"rtmp\":\"pili-live-rtmp.live.l99.com\"}}}");
            String expireAt = jsonObject.optString("expireAt");
            if (!StringUtils.isEmpty(expireAt) && expireAt.startsWith("20")){
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
                    java.util.Date date = formatter.parse(expireAt);
                    System.out.println(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test5(){
        Map map = new HashMap();
        map.put("money", 969149.04);
        Float userMoney = Float.valueOf(map.get("money").toString());
        System.out.println(userMoney);
        System.out.println(969149.04F);
    }

    @org.junit.Test
    public void test6(){
        Map map = new HashMap();
        map.put("money", 969149.04);
        Double userMoney = Double.valueOf(map.get("money").toString());
        System.out.println(userMoney);
    }

    @org.junit.Test
    public void test7(){
        int i = 1 ;
        i = i ++ ;
        System.out.println(i);
    }
}
