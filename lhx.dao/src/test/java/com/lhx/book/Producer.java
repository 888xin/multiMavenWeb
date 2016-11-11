package com.lhx.book;

/**
 * Created by lhx on 2016/10/21 14:56
 *
 * @Description
 */
public class Producer {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("混世魔王");
        SerializationUtils.writeObject(person);
    }
}
