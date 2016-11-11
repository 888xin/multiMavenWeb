package com.lhx.util.poll;

import com.lhx.model.MyComsumer;

import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhx on 2016/9/7 9:58
 *
 * @Description 创建一个定长线程池，支持定时及周期性任务执行。表示延迟1秒后每3秒执行一次。
 */
public class newScheduledThreadPoolTest3 {

    public static void main(String[] args) {


        final LinkedList<MyComsumer> linkedList = new LinkedList<MyComsumer>();
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

//        int duration = 0;
//
//        String body = "";
//
//        while (true) {
//            int num = 0;
//            if (linkedList.size() > 0) {
//                MyComsumer comsumer = linkedList.removeLast();
//                body = comsumer.getBody();
//                duration = comsumer.getDuration();
//                num++;
//                if (num > 50) {
//                    break;
//                }
//            } else {
//                break;
//            }
//        }
//
//
//        final String finalBody = body;

        scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                int num = 0;
                System.out.println(Thread.currentThread().getName());
                while (true) {
                    if (linkedList.size() > 0) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        MyComsumer comsumer = linkedList.removeLast();
                        System.out.println("处理的信息体：" + comsumer.getBody());
                        num++;
                        if (num > 2) {
                            System.out.println("数量超了………………");
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
