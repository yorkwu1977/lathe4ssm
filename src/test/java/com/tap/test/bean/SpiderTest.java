package com.tap.test.bean;

import org.junit.Test;

import com.tap.lathe4ssm.core.feature.test.TestSupport;

import javax.annotation.Resource;

/**
 * SpiderTest : 爬虫测试类
 *
 * @author StarZou
 * @since 2014-10-27 22:44
 */
public class SpiderTest extends TestSupport {

    @Resource
    private Spider spider;

    @Test
    public void testInjectSpider() throws Exception {
        System.out.println(spider);
    }
}
