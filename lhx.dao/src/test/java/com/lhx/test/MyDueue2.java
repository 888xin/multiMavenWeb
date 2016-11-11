package com.lhx.test;

import com.lhx.model.MyComsumer;

import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhx on 2016/9/27 16:30
 *
 * @Description
 */
public class MyDueue2 {


    public static void main(String[] args) {

        MyComsumer myComsumer6 = new MyComsumer();
        myComsumer6.setBody("F");
        myComsumer6.setDuration(20);
        MyDueue.linkedList.addFirst(myComsumer6);
        System.out.println("goods");

    }

}
