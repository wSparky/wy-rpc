package com.wy.netty.rpc.consumer;

import com.wy.netty.rpc.api.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangye
 * @Email wangye.wy@outllok.com
 * @CreateTime: 2022-10-10  15:19
 * @Version: 1.0.0
 * @Description: TODO
 */
@Slf4j
public class MainTest {
    public static void main(String[] args) {
        RpcClientProxy rcp = new RpcClientProxy();

        IUserService userService = rcp.clientProxy(IUserService.class, "127.0.0.1", 8081);
        System.out.println(userService.saveUser("cc "));
    }
}
