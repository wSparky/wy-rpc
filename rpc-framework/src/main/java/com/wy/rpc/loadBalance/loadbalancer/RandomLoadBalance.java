package com.wy.rpc.loadBalance.loadbalancer;

import com.wy.rpc.loadBalance.AbstractLoadBalance;
import com.wy.rpc.remoting.dto.RpcRequest;

import java.util.List;
import java.util.Random;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-21  14:34
 * @Version: 1.0.0
 * @Description: 随机均衡负载策略
 */
public class RandomLoadBalance extends AbstractLoadBalance {
    @Override
    protected String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest) {
        Random random = new Random();
        return serviceAddresses.get(random.nextInt(serviceAddresses.size()));
    }
}
