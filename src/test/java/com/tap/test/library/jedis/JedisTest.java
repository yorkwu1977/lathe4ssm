package com.tap.test.library.jedis;

import org.junit.Test;

import com.tap.lathe4ssm.core.feature.cache.redis.RedisCache;
import com.tap.lathe4ssm.core.feature.test.TestSupport;

import javax.annotation.Resource;

/**
 * JedisTest : 测试 jedis 功能
 *
 * @author StarZou
 * @since 2015-03-20 10:32
 */
public class JedisTest extends TestSupport {


    @Resource
    private RedisCache redisCache;


    @Test
    public void testSet() {
        redisCache.cache("anchor", "StarZou", 1 * 60 * 24);
    }

    @Test
    public void testGet() {
        System.out.printf(redisCache.get("anchor"));
    }
}
