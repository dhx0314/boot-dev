package cn.dhx.util.util;


import jcifs.UniAddress;
import jcifs.smb.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

/**
 * @author weizhaohui
 */
public final class SambaUtils {

    /**
     * 同步samba服务器共享目录 可同步整个共享目录 可同步单个文件，包含压缩文件
     *
     * @param remoteSmbFile Samba服务器远程路径：可以是具体文件路径，也可以是目录路径
     * @param localDir      本地目录的路径
     * @throws SmbException
     */

    public static void downloadFileFromSamba(SmbFile remoteSmbFile, String localDir) throws SmbException {
        // 判断是目录
        if (remoteSmbFile.isDirectory()) {
            // 过滤隐藏文件
//            SmbFile[] listFiles = remoteSmbFile.listFiles(new FileFilterBySamb());
            SmbFile[] listFiles = remoteSmbFile.listFiles();
            // 遍历文件夹下所有文件
            for (SmbFile smbFile : listFiles) {
                if (smbFile.isDirectory()) {
                    localDir = localDir + File.separator + smbFile.getName();
                    downloadFileFromSamba(smbFile, localDir);
                } else {
                    downloadFileFromSamba(smbFile, localDir);
                }
            }
        } else {
            if (!remoteSmbFile.exists()) {
                System.out.println("Samba服务器远程文件不存在");
                return;
            }
            if ((localDir == null) || ("".equals(localDir.trim()))) {
                System.out.println("本地目录路径不可以为空");
                return;
            }

            InputStream in = null;
            OutputStream out = null;

            try {
                // 获取远程文件的文件名,这个的目的是为了在本地的目录下创建一个同名文件
                String remoteSmbFileName = remoteSmbFile.getName();

                System.out.println(remoteSmbFileName);


                // 本地文件由本地目录，路径分隔符，文件名拼接而成
                File localFile = new File(localDir + File.separator + remoteSmbFileName);



//                System.out.println(s);
//                if (1 == 1) {
//                    return;
//                }
//                // 如果路径不存在,则创建
//                File parentFile = localFile.getParentFile();
//                if (!parentFile.exists()) {
//                    parentFile.mkdirs();
//                }

                // 打开文件输入流，指向远程的smb服务器上的文件，特别注意，这里流包装器包装了SmbFileInputStream
                in = new BufferedInputStream(new SmbFileInputStream(remoteSmbFile));
//                String s = DigestUtils.md5Hex(new FileInputStream(new File(in)));
                String s = DigestUtils.md5Hex(in);
                System.out.println(s);
                // 打开文件输出流，指向新创建的本地文件，作为最终复制到的目的地
                out = new BufferedOutputStream(new FileOutputStream(localFile));

                // 缓冲内存
                byte[] buffer = new byte[1024];
                while (in.read(buffer) != -1) {
                    out.write(buffer);
                    buffer = new byte[1024];
                }

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
//                try {
//                    out.close();
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    /**
     * 上传文件到Samba服务器指定目录
     *
     * @param url           samba远程存储路径
     * @param auth          认证
     * @param localFilePath 本地文件路径
     * @throws MalformedURLException
     * @throws SmbException
     */
    public static void uploadFileToSamba(String url, NtlmPasswordAuthentication auth, String localFilePath)
            throws MalformedURLException, SmbException {
        if ((localFilePath == null) || ("".equals(localFilePath.trim()))) {
            System.out.println("本地文件路径不可以为空");
            return;
        }

        // 检查远程父路径，不存在则创建
        SmbFile remoteSmbFile = new SmbFile(url, auth);
        String parent = remoteSmbFile.getParent();
        SmbFile parentSmbFile = new SmbFile(parent, auth);
        if (!parentSmbFile.exists()) {
            parentSmbFile.mkdirs();
        }

        InputStream in = null;
        OutputStream out = null;

        try {
            File localFile = new File(localFilePath);

            // 打开一个文件输入流执行本地文件，要从它读取内容
            in = new BufferedInputStream(new FileInputStream(localFile));

            // 打开一个远程Samba文件输出流，作为复制到的目的地
            out = new BufferedOutputStream(new SmbFileOutputStream(remoteSmbFile));

            // 缓冲内存
            byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1) {
                out.write(buffer);
                buffer = new byte[1024];
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 上传文件、文件夹到samba远程服务器
     *
     * @param remoteUrl     samba远程存储路径
     * @param auth          认证
     * @param localFilePath 本地文件路径
     * @throws MalformedURLException
     * @throws SmbException
     */
    public static void uploadAllFileToSamba(String remoteUrl, NtlmPasswordAuthentication auth, String localFilePath)
            throws MalformedURLException, SmbException {
        // 校验本地路径不能为空
        if ((localFilePath == null) || ("".equals(localFilePath.trim()))) {
            System.out.println("本地文件路径不可以为空");
            return;
        }

        // 检验本地路径是否为目录
        File localFile = new File(localFilePath);
        if (localFile.isDirectory()) {
            File[] listFiles = localFile.listFiles();
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    String localpath = file.getPath();
                    // 在samba服务器上创建目录
                    String url = remoteUrl + "/" + file.getName();
                    SmbFile remoteSmbFile = new SmbFile(url, auth);
                    if (!remoteSmbFile.exists()) {
                        remoteSmbFile.mkdirs();
                    }
                    uploadAllFileToSamba(url, auth, localpath);
                } else {
                    String newUrl = remoteUrl + "/" + file.getName();
                    String localpath = file.getPath();
                    uploadFileToSamba(newUrl, auth, localpath);
                }
            }
        } else {
//			String filePathUpload = sambaDir + "/" + new File(localFilePath).getName();
//			String url = "smb://" + host + filePathUpload;
            String newUrl = remoteUrl + "/" + new File(localFilePath).getName();
            uploadFileToSamba(newUrl, auth, localFilePath);
        }
    }

    public static void main(String[] args) throws UnknownHostException, SmbException, MalformedURLException {
        String host = "172.16.6.89";
        String username = "smbuser1";
        String password = "Wilcom021!";

        // samba服务器上的文件 注意不是linux服务器的文件路径，只是共享文件夹
        String filePath = "/samba_share/a2.txt";
        String demo1LocalDir = "C:\\D\\";
        UniAddress ua = UniAddress.getByName(host);
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(host, username, password);
        SmbSession.logon(ua, auth);// 验证是否能够成功登录
        // 创建Smb文件,地址一定要使用smb://
        SmbFile remoteSmbFile = new SmbFile("smb://" + host + filePath, auth);
        SambaUtils.downloadFileFromSamba(remoteSmbFile, demo1LocalDir);
        System.out.println("download success");

        // upload
//        String demo2LocalFile = "E:\\test\\samba\\";
//        String sambaDir = "/zhang_dawei";
//        String filePathUpload = sambaDir + "/" + new File(demo2LocalFile).getName();
//        String url = "smb://" + host + filePathUpload;
//        SambaUtils.uploadAllFileToSamba(url, auth, demo2LocalFile);
//        System.out.println("upload success");
    }


    @Test
    public void fun1() {
        String str = "C:\\D\\a.txt";
        try {
            String s = DigestUtils.md5Hex(new FileInputStream(str));
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

