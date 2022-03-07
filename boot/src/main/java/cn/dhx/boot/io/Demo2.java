package cn.dhx.boot.io;

import java.io.*;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Demo2 {


    public static void main(String[] args) {
//        try {
//            fun();
//            fun();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        new Thread(()->{
            try {
                fun();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
//
//        try {
////            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(()->{
            try {
                fun();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

    public static void fun() throws Exception {
        String filepath = "a3.txt";
        File file = new File(filepath);

        if (!file.exists()) {
            System.out.println("createNewFile()");
        }else {
            System.out.println("file exits");
        }
        String s1 = UUID.randomUUID().toString()+"\r\n";
        System.out.println(s1);
//        FileOutputStream fOS = new FileOutputStream(file.getAbsolutePath(), true);
//        DataOutputStream dos = new DataOutputStream(fOS);
//        dos.write(s1.getBytes());

        byte[] insertContent = s1.getBytes();
        insertHeader(filepath,0,insertContent);
        String s2 = UUID.randomUUID().toString()+"\r\n";
        System.out.println(s2);
        byte[] bytes = s2.getBytes();
        long l=(long)insertContent.length;
        insertHeader(filepath,l,bytes);


    }


    public static void insertHeader(String filePath,long points,byte[] insertContent){
        RandomAccessFile raf = null;
        FileOutputStream tmpOut = null;
        FileInputStream tmpIn = null;
        File tmp=null;
        try{
            tmp=File.createTempFile("tmp", null);
//	        tmp.deleteOnExit();//在JVM退出时删除

            raf =new RandomAccessFile(filePath, "rw");
            //创建一个临时文件夹来保存插入点后的数据
            tmpOut = new FileOutputStream(tmp);
            tmpIn = new FileInputStream(tmp);
            raf.seek(points);
            /**将插入点后的内容读入临时文件夹**/

            byte [] buff=new byte[1024];
            //用于保存临时读取的字节数
            int hasRead=0;
            //循环读取插入点后的内容
            while((hasRead=raf.read(buff))>0){
                // 将读取的数据写入临时文件中
                tmpOut.write(buff, 0, hasRead);
            }

            //插入需要指定添加的数据
            raf.seek(points);//返回原来的插入处
            //追加需要追加的内容
            raf.write(insertContent);
            //最后追加临时文件中的内容
            while((hasRead=tmpIn.read(buff))>0){
                raf.write(buff,0,hasRead);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                    raf=null;
                }
                if (tmpOut != null) {
                    tmpOut.close();
                    tmpOut=null;
                }
                if (tmpIn != null) {
                    tmpIn.close();
                    tmpIn=null;
                }
                if(tmp!=null) {
                    tmp.delete();
                    tmp=null;
                }
            } catch (IOException e) {

            }
        }
    }
}
