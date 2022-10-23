package com.wy.rpc.test.registry;

import com.wy.rpc.config.RpcServiceConfig;
import com.wy.rpc.remoting.dto.RpcRequest;
import com.wy.rpc.remoting.registry.ServiceDiscovery;
import com.wy.rpc.remoting.registry.ServiceRegistry;
import com.wy.rpc.remoting.registry.ZkServiceDiscoveryImpl;
import com.wy.rpc.remoting.registry.ZkServiceRegistryImpl;
import com.wy.rpc.test.service.DemoRpcService;
import com.wy.rpc.test.service.DemoRpcServiceImpl;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-22  10:12
 * @Version: 1.0.0
 * @Description: ZooKeeper注册服务测试,通过
 */
public class ZKServiceRegistryImplTest {
    @Test
    public void ZooKeeperTest(){
        ServiceRegistry zkServiceRegistry = new ZkServiceRegistryImpl();
        InetSocketAddress givenInetSocketAddress = new InetSocketAddress("124.221.174.54", 2181);
        DemoRpcService demoRpcService = new DemoRpcServiceImpl();
        RpcServiceConfig rpcServiceConfig = RpcServiceConfig.builder()
                .group("test2").version("version2").service(demoRpcService).build();
        zkServiceRegistry.registerService(rpcServiceConfig.getRpcServiceName(), givenInetSocketAddress);
        ServiceDiscovery zkServiceDiscovery = new ZkServiceDiscoveryImpl();
        RpcRequest rpcRequest = RpcRequest.builder()
//                .parameters(args)
                .interfaceName(rpcServiceConfig.getServiceName())
//                .paramTypes(method.getParameterTypes())
                .requestId(UUID.randomUUID().toString())
                .group(rpcServiceConfig.getGroup())
                .version(rpcServiceConfig.getVersion())
                .build();
        InetSocketAddress acquiredInetSocketAddress = zkServiceDiscovery.lookupService(rpcRequest);
        assertEquals(givenInetSocketAddress.toString(), acquiredInetSocketAddress.toString());
    }
}
