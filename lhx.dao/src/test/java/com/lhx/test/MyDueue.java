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
public class MyDueue {

    static final LinkedList<MyComsumer> linkedList = new LinkedList<MyComsumer>();


    public static void main(String[] args) {


        MyComsumer myComsumer = new MyComsumer();
        myComsumer.setBody("A");
        myComsumer.setDuration(10);
        linkedList.addFirst(myComsumer);

        MyComsumer myComsumer2 = new MyComsumer();
        myComsumer2.setBody("B");
        myComsumer2.setDuration(20);
        linkedList.addFirst(myComsumer2);

        MyComsumer myComsumer3 = new MyComsumer();
        myComsumer3.setBody("C");
        myComsumer3.setDuration(20);
        linkedList.addFirst(myComsumer3);

        MyComsumer myComsumer4 = new MyComsumer();
        myComsumer4.setBody("D");
        myComsumer4.setDuration(20);
        linkedList.addFirst(myComsumer4);

        MyComsumer myComsumer5 = new MyComsumer();
        myComsumer5.setBody("E");
        myComsumer5.setDuration(20);
        linkedList.addFirst(myComsumer5);


        final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

        scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                int num = 0;
                System.out.println(Thread.currentThread().getName());
                while (true) {
                    if (linkedList.size() > 0) {
                        try {
                            //此处模拟每一次处理需要3秒钟
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        MyComsumer comsumer = linkedList.removeLast();
                        System.out.println("处理的信息体：" + comsumer.getBody());
                        num++;
                        if (num > 2) {
                            System.out.println("数量超过2了………………");
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }, 0, 1, TimeUnit.SECONDS);


        try {
            Thread.sleep(20000);
            MyComsumer myComsumer6 = new MyComsumer();
            myComsumer6.setBody("F");
            myComsumer6.setDuration(20);
            MyDueue.linkedList.addFirst(myComsumer6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
