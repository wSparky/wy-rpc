package com.wy.rpc.provider;

import com.wy.rpc.config.RpcServiceConfig;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-16  12:47
 * @Version: 1.0.0
 * @Description: 服务提供者
 */
public interface ServiceProvider {

    void addService(RpcServiceConfig rpcServiceConfig);

    Object getService(String rpcServiceName);

    void publishService(RpcServiceConfig rpcServiceConfig);
}
