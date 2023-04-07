package cn.dhx.io.streamio.bytestream;

import cn.dhx.pojo.Stu;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MyObjectOutputStream {

    @Test
    public void fun1() throws Exception {
        String path = "e:\\a\\object.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeInt(100);
        objectOutputStream.writeUTF("String info");
        objectOutputStream.writeObject(new Stu("11", "aa"));
        objectOutputStream.close();

    }
}
