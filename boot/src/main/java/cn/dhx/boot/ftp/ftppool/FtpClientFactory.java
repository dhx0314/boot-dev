package cn.dhx.boot.ftp.ftppool;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
@Component
public class FtpClientFactory implements PooledObjectFactory<FTPClient> {

    @Autowired
    private FtpConfig conf;

    @Override
    public PooledObject<FTPClient> makeObject() throws Exception {
        FTPClient ftpClient=null;
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(conf.getHost(), conf.getPort());
            ftpClient.login(conf.getUsername(), conf.getPassword());
            ftpClient.setConnectTimeout(5000);
            ftpClient.setControlEncoding("UTF-8");
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                log.info("未连接到FTP，用户名或密码错误");
                ftpClient.disconnect();
            } else {
                log.info("FTP连接成功");
            }

        } catch (Exception e) {
            log.info("FTP的IP地址可能错误，请正确配置");
        }
        return new DefaultPooledObject<FTPClient>(ftpClient);
    }
    /**
     * 销毁对象
     *
     * @param p
     * @throws Exception
     */
    @Override
    public void destroyObject(PooledObject<FTPClient> p) throws Exception {
        FTPClient ftpClient = p.getObject();
        try {
            if (ftpClient != null && ftpClient.isConnected()) {
                ftpClient.logout();
            }
        } catch (IOException e) {
            log.info(" destroyObject {}",e.getMessage());
        } finally {
            // 注意,一定要在finally代码中断开连接，否则会导致占用ftp连接情况
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                log.info(" destroyObject {}",e.getMessage());
            }
        }
    }
    /**
     * 验证对象是否可用
     *
     * @param p
     * @return
     */
    @Override
    public boolean validateObject(PooledObject<FTPClient> p) {
//        FTPClient ftpClient = p.getObject();
//        try {
//            return ftpClient.sendNoOp();
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to validate client: " + e, e);
//        }
        return true;
    }
    /**
     * 激活一个对象，使其可用用
     *
     * @param p
     * @throws Exception
     */
    @Override
    public void activateObject(PooledObject<FTPClient> p) throws Exception {

    }
    /**
     * 钝化一个对象,也可以理解为反初始化
     *
     * @param p
     * @throws Exception
     */
    @Override
    public void passivateObject(PooledObject<FTPClient> p) throws Exception {

    }
}
