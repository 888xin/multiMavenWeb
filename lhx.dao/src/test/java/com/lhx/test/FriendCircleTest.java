package com.lhx.test;

import com.lhx.dao.*;
import com.lhx.model.BetJc;
import com.lhx.model.BetOp;
import com.lhx.model.FriendCircle;
import com.lhx.model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by lhx on 16-4-6 下午6:28
 *
 * @Description
 */
public class FriendCircleTest {

    private FriendCircleDao friendCircleDao ;
    private BbBetOpDao bbBetOpDao ;
    private BbBetJcDao bbBetJcDao ;

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        friendCircleDao = (FriendCircleDao) context.getBean("friendCircleDao");
        bbBetOpDao = (BbBetOpDao) context.getBean("bbBetOpDao");
        bbBetJcDao = (BbBetJcDao) context.getBean("bbBetJcDao");
    }

    @org.junit.Test
    public void test1() throws JSONException {
        List<FriendCircle> list = friendCircleDao.getInnerCircles();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            FriendCircle friendCircle = list.get(i);

            JSONObject jsonobj = new JSONObject(friendCircle.getParams());
            JSONObject bet = jsonobj.getJSONObject("bet");
            Long bId = bet.getLong("bId");
            Integer playId = bet.getInt("playId");
            if (playId == 6){
                //胜平负
                BetOp betOp = bbBetOpDao.selectById(bId);
                bet.put("r3",betOp.getAwayRoi());
            } else if (playId == 7){
                //让球胜平负
                BetJc betJc = bbBetJcDao.selectById(bId);
                bet.put("r3",betJc.getAwayRoi());
            }
            jsonobj.put("bet",bet);
            String params = jsonobj.toString();
//            int n = 4 ;
            FriendCircle friendCircle1 = new FriendCircle();
            friendCircle1.setParams(params);
            friendCircle1.setId(friendCircle.getId());

            int n = friendCircleDao.uploadParams(friendCircle1);
            System.out.println(n);
        }



    }
}
