package cn.dhx.util.util;

import jcifs.smb.SmbFile;

import java.net.MalformedURLException;

/**
 * @Author daihongxin
 * @create 2023/3/2 16:36
 */
public class MySambaUtils {

    public static void main(String[] args) throws MalformedURLException {
        String remoteFileURL="";
        SmbFile remoteSmbFile = new SmbFile(remoteFileURL);

        //获取远程文件的文件名,这个的目的是为了在本地的目录下创建一个同名文件
        String remoteSmbFileName = remoteSmbFile.getName();
    }
}
