package cn.dhx.util;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

import java.io.*;

/**
 * @Author daihongxin
 * @create 2023/3/2 16:20
 */
public class SambaFileAccessUtil {

    private SambaFileAccessUtil() {}

    /**
     * 从samba服务器上下载指定的文件到本地目录
     * @param remoteFileURL   Samba服务器远程文件的路径
     * @param localDir        本地目录的路径
     */

    public static void downloadFileFromSamba(String remoteFileURL, String localDir){

        //入参检查
        if (  (remoteFileURL==null) || ("".equals(remoteFileURL.trim()))){
            System.out.println("Samba服务器远程文件路径不可以为空");
            return;
        }
        //入参检查
        if( (localDir==null) || ("".equals(localDir.trim()))){
            System.out.println("本地目录路径不可以为空");
            return;
        }

        InputStream in = null;
        OutputStream out = null;

        try{
            //创建一个smbFile对象对应远程服务器上的SmbFile
            SmbFile remoteSmbFile = new SmbFile(remoteFileURL);

            //获取远程文件的文件名,这个的目的是为了在本地的目录下创建一个同名文件
            String remoteSmbFileName = remoteSmbFile.getName();

            //本地文件由本地目录，路径分隔符，文件名拼接而成
            File localFile = new File(localDir+File.separator+remoteSmbFileName);

            //打开文件输入流，指向远程的smb服务器上的文件，特别注意，这里流包装器包装了SmbFileInputStream
            in= new BufferedInputStream(new SmbFileInputStream(remoteSmbFile));
            //打开文件输出流，指向新创建的本地文件，作为最终复制到的目的地
            out = new BufferedOutputStream(new FileOutputStream(localFile));

            //缓冲内存
            byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1){
                out.write(buffer);
                buffer = new byte[1024];
            }

        }catch (Exception e){
            e.printStackTrace();

        }finally{
            try  {
                out.close();
                in.close();
            } catch  (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 上传本地文件到Samba服务器指定目录
     * @param remoteDirURL  Samba服务器远程目录的路径
     * @param localFilePath 本地文件路径
     */
    public static void uploadFileToSamba(String remoteDirURL,String localFilePath){

        //入参检查
        if (  (remoteDirURL==null) || ("".equals(remoteDirURL.trim()))){
            System.out.println("Samba服务器远程目录路径不可以为空");
            return;
        }

        //入参检查
        if( (localFilePath==null) || ("".equals(localFilePath.trim()))){
            System.out.println("本地文件路径不可以为空");
            return;
        }

        InputStream in = null;
        OutputStream out = null;

        try{
            //创建一个本地文件对象
            File localFile = new File(localFilePath);

            //获取本地文件的文件名，这个名字用于在远程的Samba服务器上指定目录创建同名文件
            String localFileName = localFile.getName();

            //创建远程服务器上Samba文件对象
            SmbFile remoteSmbFile = new SmbFile(remoteDirURL+File.separator+localFileName);

            //打开一个文件输入流执行本地文件，要从它读取内容
            in = new  BufferedInputStream( new  FileInputStream(localFile));

            //打开一个远程Samba文件输出流，作为复制到的目的地
            out = new  BufferedOutputStream( new SmbFileOutputStream(remoteSmbFile));

            //缓冲内存
            byte [] buffer =  new   byte [ 1024 ];
            while  (in.read(buffer) != - 1 ) {
                out.write(buffer);
                buffer = new byte[ 1024 ];
            }

        } catch  (Exception e) {
            e.printStackTrace();

        } finally  {
            try  {
                out.close();
                in.close();
            } catch  (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

