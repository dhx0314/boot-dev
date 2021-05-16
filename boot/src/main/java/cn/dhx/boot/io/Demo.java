package cn.dhx.boot.io;

import cn.dhx.boot.io.file.PcmFile;

import javax.swing.plaf.TableHeaderUI;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException {
//        BosDemo bosDemo = new BosDemo();
//        bosDemo.write();
//        bosDemo.read();
//        bosDemo.read2();

        PcmFile session = new PcmFile("session");
        byte[] b=new byte[1024];
        for (int i = 0; i < 1024; i++) {
            byte j= (byte) i;
            b[i]=j;

        }
        for (int i = 0; i < 11; i++) {
            session.writeData(b);

        }

        File file = new File("d:\\bos.txt");
        System.out.println(file.length());
    }

}
