package com.wy.rpc.test.registry.zkTest;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-22  12:59
 * @Version: 1.0.0
 * @Description: 检查是否能与远程服务器ZooKeeper连上
 */
public class connectTest {
    /**
     *连接测试
     */
    @Test
    public void testConnect(){
        //一
        RetryPolicy retryPolicy= new ExponentialBackoffRetry(3000,10);
        CuratorFramework client = CuratorFrameworkFactory.newClient("124.221.174.54:2181",
                60 * 1000, 15 * 1000,retryPolicy);
        client.start();

    }
}
