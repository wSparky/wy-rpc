package com.wy.rpc.provider;

import com.wy.rpc.netty.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wangye
 * @Email wangye.wy@outllok.com
 * @CreateTime: 2022-10-10  15:12
 * @Version: 1.0.0
 * @Description: TODO
 */
@ComponentScan(basePackages = {"com.wy.rpc.provider", "com.wy.rpc.netty.spring"})
@SpringBootApplication
public class NettyRpcProvider {

    public static void main(String[] args) {
        SpringApplication.run(NettyRpcProvider.class, args);
        // 启动netty服务端
        new NettyServer("127.0.0.1", 8081).startNettyServer();
    }
}
