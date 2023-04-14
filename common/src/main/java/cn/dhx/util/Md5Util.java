package cn.dhx.util;

import jcifs.smb.SmbFileInputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Author daihongxin
 * @create 2023/3/27 11:22
 */

@Slf4j
public class Md5Util {


    public static boolean md5(String oldPath, String newPath) {

        try (FileInputStream oldInputStream = new FileInputStream(oldPath);
             FileInputStream mewInputStream = new FileInputStream(newPath);) {
            String oldMd5 = DigestUtils.md5Hex(oldInputStream);
            String newMd5 = DigestUtils.md5Hex(mewInputStream);
            if (oldMd5.equals(newMd5)) {
                return true;
            }
            log.info("old {} old md5{}, new {} new md5 {}", oldPath, oldMd5, newPath, newMd5);
        } catch (Exception e) {
            log.info("md5 error", e);
        }
        return false;
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

    public static boolean md5Samba(String sambaFilePath, String filePath) {


        try (SmbFileInputStream smbFileInputStream = new SmbFileInputStream(sambaFilePath);
             FileInputStream fileInputStream = new FileInputStream(filePath);) {
            String smbMd5 = DigestUtils.md5Hex(smbFileInputStream);
            String filePathMd5 = DigestUtils.md5Hex(fileInputStream);
            String substring = sambaFilePath.substring(sambaFilePath.indexOf("@"));
            log.info("sambaFilePath {} md5 {}, filePath {} md5 {}", substring, smbMd5, filePath, filePathMd5);
            if (smbMd5.equals(filePathMd5)) {
                return true;
            }
        } catch (Exception e) {
            log.info("md5 error", e);
        }
        return false;
    }


}
