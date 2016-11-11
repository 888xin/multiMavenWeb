package com.lhx.test;

import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhx on 2016/9/27 16:30
 *
 * @Description
 */
public class MyDueue3 {

    static final LinkedList<String> linkedList = new LinkedList<String>();


    public static void main(String[] args) {


        //队列里面的任务，先进先出
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        linkedList.addFirst("D");
        linkedList.addFirst("E");




        final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

        scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                int num = 0;
                System.out.println(Thread.currentThread().getName() + " 2秒遍历检查一遍");
                while (true) {
                    if (linkedList.size() > 0) {
                        try {
                            //此处模拟每一次处理需要3秒钟
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("处理的信息体：" + linkedList.removeLast());
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
        }, 0, 2, TimeUnit.SECONDS);


        try {
            //模拟10秒后加入新的任务
            Thread.sleep(10000);
            linkedList.addFirst("F");
            linkedList.addFirst("G");
            linkedList.addFirst("H");
            linkedList.addFirst("I");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
