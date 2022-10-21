package com.wy.rpc.loadBalance;

import com.wy.rpc.remoting.dto.RpcRequest;
import github.wy.utils.CollectionUtil;

import java.util.Collection;
import java.util.List;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-21  14:24
 * @Version: 1.0.0
 * @Description: 均衡负载的抽象类
 */
public abstract class AbstractLoadBalance implements LoadBalance {
    @Override
    public String selectServiceAddress(List<String> serviceAddress, RpcRequest rpcRequest) {
        if (CollectionUtil.isEmpty(serviceAddress)) {
            return null;
        }
        if (serviceAddress.size() == 1) {
            return serviceAddress.get(0);
        }
        return doSelect(serviceAddress,rpcRequest);
    }

    protected abstract String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest);
}
