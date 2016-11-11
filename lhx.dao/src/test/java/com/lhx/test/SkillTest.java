package com.lhx.test;

/**
 * Created by lhx on 2016/10/11 11:31
 *
 * @Description
 */
public class SkillTest {

    @org.junit.Test
    public void test1(){
        //instanceof 只能用于对象的判断，不能用于基本类型的判断
        String n = null ;
        System.out.println(n instanceof String);
    }

    @org.junit.Test
    public void test2(){
        //用偶判断，不用奇判断
        System.out.println(-1 % 2 == 1? "奇数" : "偶数");
    }

    @org.junit.Test
    public void test3(){
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.println(i.compareTo(j));
    }
}
