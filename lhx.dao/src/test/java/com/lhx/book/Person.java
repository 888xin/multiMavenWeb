package com.lhx.book;

import java.io.Serializable;

/**
 * Created by lhx on 2016/10/21 14:55
 *
 * @Description
 */
public class Person implements Serializable{

    private static final long serialVersionUID = 11123L ;

    private String name ;

    private int age ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
