package com.wy.rpc.loadBalance;

import com.wy.rpc.remoting.dto.RpcRequest;
import github.wy.extension.SPI;
import io.protostuff.Rpc;

import java.util.List;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-21  14:21
 * @Version: 1.0.0
 * @Description: 负载均衡策略接口
 */
@SPI
public interface LoadBalance {

    String selectServiceAddress(List<String> serviceUrlList, RpcRequest rpcRequest);
}
