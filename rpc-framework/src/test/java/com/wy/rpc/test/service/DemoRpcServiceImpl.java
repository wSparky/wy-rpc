package com.wy.rpc.test.service;


import com.wy.rpc.annotation.RpcService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-22  10:31
 * @Version: 1.0.0
 * @Description: TODO
 */
@Slf4j
@RpcService(group = "test1",version = "version1")
public class DemoRpcServiceImpl implements DemoRpcService{
    @Override
    public String hello() {
        return "hello";
    }
}
