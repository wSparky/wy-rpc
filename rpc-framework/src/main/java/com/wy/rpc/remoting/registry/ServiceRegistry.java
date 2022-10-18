package com.wy.rpc.remoting.registry;

import github.wy.extension.SPI;

import java.net.InetSocketAddress;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-17  21:09
 * @Version: 1.0.0
 * @Description: 服务注册接口,通过SPI机制实现类
 */
@SPI
public interface ServiceRegistry {

    void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress);
}
