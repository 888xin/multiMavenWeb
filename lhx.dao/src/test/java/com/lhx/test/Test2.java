package com.lhx.test;

import com.lhx.dao.ContentInfoDao;
import com.lhx.model.ContentInfo;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by lhx on 15-9-9 上午9:34
 *
 * @Description
 */
public class Test2 {

    private ContentInfoDao contentInfoDao ;


    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        contentInfoDao = (ContentInfoDao) context.getBean("contentInfoDao");
    }

    @org.junit.Test
    public void testInsertContentInfo(){
        ContentInfo contentInfo = new ContentInfo(1L,2L,"test","$$$测试",null,0,null,0.0,0.0,"深圳", new Date());
        contentInfo.setContentId(100L);
        boolean flag = contentInfoDao.insert(contentInfo);
        System.out.println(flag);
    }
}
