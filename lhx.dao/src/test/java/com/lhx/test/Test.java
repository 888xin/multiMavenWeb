package com.lhx.test;

import com.lhx.dao.UserDao;
import com.lhx.model.User;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        userDao = (UserDao) context.getBean("userDao");
    }

    @org.junit.Test
    public void testInsert(){
        User user = new User();
        user.setId(3);
        user.setNickname("新");
        user.setState(5);
        userDao.insertUser(user) ;
    }
}
