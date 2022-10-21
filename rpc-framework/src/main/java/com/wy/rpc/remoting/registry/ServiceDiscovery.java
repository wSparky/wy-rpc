package com.wy.rpc.remoting.registry;

import com.wy.rpc.remoting.dto.RpcRequest;
import github.wy.extension.SPI;

import java.net.InetSocketAddress;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-21  13:54
 * @Version: 1.0.0
 * @Description: 服务发现接口，通过rpcServiceName发现服务
 *
 */
@SPI
public interface ServiceDiscovery {

    InetSocketAddress lookupService(RpcRequest rpcRequest);
}
