package com.wy.rpc.consumer;

import java.lang.reflect.Proxy;

/**
 * @author wangye
 * @Email wangye.wy@outllok.com
 * @CreateTime: 2022-10-10  15:15
 * @Version: 1.0.0
 * @Description: 动态代理类
 */

public class RpcClientProxy {

    public <T> T clientProxy(final Class<T> interfaceCls, final String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls}, new RpcInvokerProxy(host, port));
    }
}
