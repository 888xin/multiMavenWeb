package com.lhx.book;

import java.io.*;

/**
 * Created by lhx on 2016/10/21 14:50
 *
 * @Description
 */
public class SerializationUtils {
    private static String FILE_NAME = "E:/obj.bin";

    //序列化
    public static void writeObject(Serializable s){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(s);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //反序列化
    public static Object readObject(){
        Object obj = null ;
        try {
            ObjectInput input = new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj = input.readObject();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
