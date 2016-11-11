package com.lhx.book;

/**
 * Created by lhx on 2016/10/21 14:58
 *
 * @Description
 */
public class Consumer {

    public static void main(String[] args) {
        Person p = (Person) SerializationUtils.readObject();
        System.out.println(p.getName());
        System.out.println(p.getAge());
    }
}
