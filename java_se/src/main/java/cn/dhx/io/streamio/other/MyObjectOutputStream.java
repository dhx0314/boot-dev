package cn.dhx.io.streamio.other;

import cn.dhx.pojo.Stu;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


//序列化
public class MyObjectOutputStream {



    @Test
    public void ObjectInputStream() throws Exception {
        String path = "io\\object.txt";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readUTF());
        Object object = objectInputStream.readObject();
        System.out.println(object.getClass() +"_"+ object);
        objectInputStream.close();
    }

    @Test
    public void ObjectOutputStream() throws Exception {
        String path = "io\\object.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeInt(100);
        objectOutputStream.writeUTF("String info");
        objectOutputStream.writeObject(new Stu("11", "aa"));
        objectOutputStream.close();

    }
}
