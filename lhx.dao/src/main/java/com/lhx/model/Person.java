package com.lhx.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by lhx on 2016/10/11 9:29
 *
 * @Description
 */
public class Person implements Serializable {

    private String name ;

    private transient Double salary ;

    public Person(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    //序列化委托方法
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.writeInt(salary.getBasePay());
    }

    //反序列化委托方法
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //salary = new Salary(in.readInt(), 0);
    }
}
