package com.lhx.util.poll;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhx on 2016/9/7 9:58
 *
 * @Description 创建一个定长线程池，支持定时及周期性任务执行。表示延迟1秒后每3秒执行一次。
 */
public class newScheduledThreadPoolTest2 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
