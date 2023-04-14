package cn.dhx.util;


import cn.hutool.core.io.IoUtil;
import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2CreateOptions;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.DiskShare;
import com.hierynomus.smbj.share.File;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

/**
 * @author dhx
 */
@Slf4j
@Component
public class SambaUtils {




    public void down() {
//        String str2 = "smb://smbuser1:Wilcom021!@172.16.6.89/samba_share/a2.txt";
        String smbFormat = "smb://%s:%s@%s";
        String host = "172.16.6.77";
        String username = "smbuser1";
        String password = "Wilcom021!";
        try {
            String smb = String.format(smbFormat, username, password, host);
            String filePath = smb + "/filepath/2023/a.txt";

            BufferedInputStream in = new BufferedInputStream(new SmbFileInputStream(filePath));
            FileOutputStream fileOutputStream = new FileOutputStream("a2.txt");
            IOUtils.copy(in, fileOutputStream);
        } catch (Exception e) {
            log.error("error", e);
        }
    }




    public void down2() {

        String host = "172.16.6.77";
        String username = "smbuser1";
        String password = "Wilcom021!";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("a.txt");
            SmbConfig config = SmbConfig.builder().withTimeout(120, TimeUnit.SECONDS)
                    .withTimeout(120, TimeUnit.SECONDS) // 超时设置读，写和Transact超时（默认为60秒）
                    .withSoTimeout(180, TimeUnit.SECONDS) // Socket超时（默认为0秒）
                    .build();

            // 如果不设置超时时间	SMBClient client = new SMBClient();
            SMBClient client = new SMBClient(config);
            Connection connect = client.connect(host);
            AuthenticationContext ac = new AuthenticationContext(username, password.toCharArray(), ".");
            Session session = connect.authenticate(ac);
            DiskShare share = (DiskShare) session.connectShare("filePath");
            String folder = "/2023/a.txt";
            File file = share.openFile(folder, EnumSet.of(AccessMask.GENERIC_READ), null, SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
            InputStream smbFileInputStream = file.getInputStream();
            IoUtil.copy(smbFileInputStream, fileOutputStream);
            FileInputStream fileInputStream = new FileInputStream("a.txt");
            InputStream inputStream = file.getInputStream();
            boolean b = Md5Util.md52(inputStream, fileInputStream);
            System.out.println(b);

        } catch (Exception e) {
            log.error("samba download error ", e);
        }
    }


    public void upload() {
        BufferedOutputStream out = null;
        String smbFormat = "smb://%s:%s@%s";
        String host = "172.16.6.89";
        String username = "smbuser1";
        String password = "Wilcom021!";
        try {
            String smb = String.format(smbFormat, username, password, host);
            String filePath = smb + "/filePath/2023/03/29/upload223.wav";
            out = new BufferedOutputStream(new SmbFileOutputStream(filePath));
            FileInputStream fileInputStream = new FileInputStream("a2.wav");
            IOUtils.copy(fileInputStream, out);
        } catch (Exception e) {
            log.error("error", e);
        }
    }


    public void upload2() {
//        String str2 = "smb://smbuser1:Wilcom021!@172.16.6.89/samba_share/a2.txt";
        String smbFormat = "smb://%s:%s@%s";
        String host = "172.16.6.77";
        String username = "smbuser1";
        String password = "Wilcom021!";
        try {

            SmbConfig config = SmbConfig.builder().withTimeout(120, TimeUnit.SECONDS)
                    .withTimeout(120, TimeUnit.SECONDS) // 超时设置读，写和Transact超时（默认为60秒）
                    .withSoTimeout(180, TimeUnit.SECONDS) // Socket超时（默认为0秒）
                    .build();

            // 如果不设置超时时间	SMBClient client = new SMBClient();
            SMBClient client = new SMBClient(config);
            Connection connect = client.connect(host);
            AuthenticationContext ac = new AuthenticationContext(username, password.toCharArray(), ".");
            Session session = connect.authenticate(ac);
            DiskShare share = (DiskShare) session.connectShare("filePath");
            String folder = "/2023/a222.txt";

            File file = share.openFile(folder, EnumSet.of(AccessMask.GENERIC_WRITE),
                    EnumSet.of(FileAttributes.FILE_ATTRIBUTE_NORMAL), SMB2ShareAccess.ALL,
                    SMB2CreateDisposition.FILE_OVERWRITE_IF, EnumSet.noneOf(SMB2CreateOptions.class));

            FileInputStream fileInputStream = new FileInputStream("doload2222.txt");

            OutputStream outputStream = file.getOutputStream();
            IoUtil.copy(fileInputStream, outputStream);
            InputStream inputStream = file.getInputStream();
            boolean b = md52(fileInputStream, inputStream);
            System.out.println(b);

        } catch (Exception e) {
            log.error("samba download error ", e);
        }
    }


    public static boolean md52(InputStream oldInputStream, InputStream mewInputStream) {

        try {
            String oldMd5 = DigestUtils.md5Hex(oldInputStream);
            String newMd5 = DigestUtils.md5Hex(mewInputStream);
            if (oldMd5.equals(newMd5)) {
                return true;
            }
            log.info("old {} old md5{}, new {} new md5 {}", "oldPath", oldMd5, "newPath", newMd5);
        } catch (Exception e) {
            log.info("md5 error", e);
        }
        return false;
    }


}

