package cn.dhx.boot.ftppool;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class FtpPool extends GenericObjectPool<FTPClient> {
    public FtpPool(PooledObjectFactory<FTPClient> factory) {
        super(factory);
    }

    public FtpPool(PooledObjectFactory<FTPClient> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }

    public FtpPool(PooledObjectFactory<FTPClient> factory, GenericObjectPoolConfig config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
