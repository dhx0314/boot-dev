package cn.dhx.boot.filter;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author daihongxin
 * @create 2023/7/25 11:19
 */
@Slf4j
@Component
public class RedissonBloomFilter {

    @Autowired
    private RedissonClient redissonClient;

    public void testBloom() {
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("phoneList");
        //初始化布隆过滤器：预计元素为100000000L,误差率为3%
        bloomFilter.tryInit(100000000L,0.03);
        //将号码10086插入到布隆过滤器中
        bloomFilter.add("10086");
        bloomFilter.add("10087");
        bloomFilter.add("10089");

        //判断下面号码是否在布隆过滤器中
        System.out.println(bloomFilter.contains("123456"));//false
        System.out.println(bloomFilter.contains("10086"));//true
    }
}
