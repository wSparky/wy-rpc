package com.wy.rpc.remoting.registry;

import com.wy.rpc.loadBalance.LoadBalance;
import com.wy.rpc.remoting.dto.RpcRequest;
import github.wy.enums.RpcErrorMessageEnum;
import github.wy.exception.RpcException;
import github.wy.extension.ExtensionLoader;
import github.wy.utils.CollectionUtil;
import github.wy.utils.CuratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-21  14:02
 * @Version: 1.0.0
 * @Description: 服务发现实现类
 */
@Slf4j
public class ZkServiceDiscoveryImpl implements ServiceDiscovery{
    private final LoadBalance loadBalance;

    public ZkServiceDiscoveryImpl(){
        this.loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("loadBalance");
    }


    @Override
    public InetSocketAddress lookupService(RpcRequest rpcRequest) {
        String rpcServiceName = rpcRequest.getRpcServiceName();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient,rpcServiceName);
        if(CollectionUtil.isEmpty(serviceUrlList)){
            throw new RpcException(RpcErrorMessageEnum.SERVICE_INVOCATION_FAILURE,rpcServiceName);

        }
        //负载均衡
        String targetServiceUrl = loadBalance.selectServiceAddress(serviceUrlList,rpcRequest);
        log.info("Successfully found the service address: [{}]", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host,port);
    }
}
