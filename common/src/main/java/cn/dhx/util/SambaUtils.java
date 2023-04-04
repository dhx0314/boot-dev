package cn.dhx.util;


import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author dhx
 */
@Slf4j
@Component
public class SambaUtils {




    public void down() {
//        String str2 = "smb://smbuser1:Wilcom021!@172.16.6.89/samba_share/a2.txt";
        String smbFormat = "smb://%s:%s@%s";
        String host = "172.16.6.145";
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


}

