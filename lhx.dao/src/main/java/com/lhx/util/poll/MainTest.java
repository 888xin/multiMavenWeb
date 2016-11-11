package com.lhx.util.poll;

import java.util.LinkedList;

/**
 * Created by lhx on 2016/9/8 9:49
 *
 * @Description
 */
public class MainTest {

    public static void main(String[] args) {
        System.out.println("run before");
        DisableThreadPoolUtil.getInstance().fresh(4L);
        System.out.println("run after");
    }
}
