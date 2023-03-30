package cn.dhx.io.old.bio.stream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MyObjectInoutStream {

    @Test
    public void fun1() throws Exception {
        String path = "e:\\a\\object.txt";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readUTF());
        Object object = objectInputStream.readObject();
        System.out.println(object.getClass());
        System.out.println(object);
        objectInputStream.close();
    }
}
