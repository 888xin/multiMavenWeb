package com.lhx.util.poll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lhx on 2016/9/7 9:55
 *
 * @Description
 */
public class newFixedThreadPoolUtil {

    private final int LIMIT_NUMBER = 3 ;

    private ExecutorService fixedThreadPool ;

    private static newFixedThreadPoolUtil ourInstance = new newFixedThreadPoolUtil();

    public static newFixedThreadPoolUtil getInstance() {
        return ourInstance;
    }

    private newFixedThreadPoolUtil() {
        fixedThreadPool = Executors.newFixedThreadPool(LIMIT_NUMBER);
    }

    public void fresh(final long userId){
        fixedThreadPool.execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(6000);
                    System.out.println(userId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("s");
        newFixedThreadPoolUtil.getInstance().fresh(3L);
        newFixedThreadPoolUtil.getInstance().fresh(4L);
        newFixedThreadPoolUtil.getInstance().fresh(5L);
        newFixedThreadPoolUtil.getInstance().fresh(6L);
        newFixedThreadPoolUtil.getInstance().fresh(7L);
        newFixedThreadPoolUtil.getInstance().fresh(100L);
        System.out.println("k");
    }

}
