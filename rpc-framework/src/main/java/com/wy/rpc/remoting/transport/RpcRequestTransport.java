package com.wy.rpc.remoting.transport;

import com.wy.rpc.remoting.dto.RpcRequest;
import github.wy.extension.SPI;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-24  21:50
 * @Version: 1.0.0
 * @Description: 发送RpcRequest
 */
@SPI
public interface RpcRequestTransport {
    Object sendRpcRequest(RpcRequest rpcRequest);
}
