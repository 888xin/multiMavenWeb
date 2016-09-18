package com.lhx.util.poll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lhx on 2016/9/7 10:39
 *
 * @Description
 */
public class DisableThreadPoolUtil {

    private final int LIMIT_NUMBER = 3 ;

    private ExecutorService fixedThreadPool ;

    private static DisableThreadPoolUtil ourInstance = new DisableThreadPoolUtil();

    public static DisableThreadPoolUtil getInstance() {
        return ourInstance;
    }

    private DisableThreadPoolUtil() {
        fixedThreadPool = Executors.newFixedThreadPool(LIMIT_NUMBER);
    }

    public void fresh(final Long userId){

        fixedThreadPool.execute(new Runnable() {
            public void run() {
                int n = 0;
                while (true) {
                    System.out.println("run at " + userId + " : " + n);
                    if (n > 5){
                        System.out.println("out");
                        break;
                    }
                    n++;
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }
}
