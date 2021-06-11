package cn.dhx.util.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class TestObjectPool extends GenericObjectPool<TestObject> {
    public TestObjectPool(PooledObjectFactory<TestObject> factory) {
        super(factory);
    }

    public TestObjectPool(PooledObjectFactory<TestObject> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }

    public TestObjectPool(PooledObjectFactory<TestObject> factory, GenericObjectPoolConfig config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
