package com.wy.rpc.consumer;

import com.wy.rpc.constant.ReqType;
import com.wy.rpc.constant.RpcConstant;
import com.wy.rpc.constant.SerialType;
import com.wy.rpc.netty.NettyClient;
import com.wy.rpc.protocol.*;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangye
 * @Email wangye.wy@outllok.com
 * @CreateTime: 2022-10-10  15:17
 * @Version: 1.0.0
 * @Description: Rpc动态代理
 */
public class RpcInvokerProxy implements InvocationHandler {

    private String host;

    private int port;

    public RpcInvokerProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin invoke target server");
        RpcProtocol<RpcRequest> reqProtocol = new RpcProtocol<>();
        long requestId = RequestHolder.REQUEST_ID.incrementAndGet();
        Header header = new Header(RpcConstant.MAGIC, SerialType.JSON_SERIAL.code(),
                ReqType.REQUEST.code(), requestId, 0);
        reqProtocol.setHeader(header);

        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParamsTypes(method.getParameterTypes());
        request.setParams(args);
        reqProtocol.setContent(request);

        //短链接
        NettyClient nettyClient = new NettyClient(host, port);
        // 通过设置DefaultEventLoop进行轮询获取结果
        RpcFuture<RpcResponse> future = new RpcFuture<>(new DefaultPromise<RpcResponse>(new DefaultEventLoop()));
        // 保存请求ID和返回数据的对应关系
        RequestHolder.REQUEST_MAP.put(requestId, future);
        nettyClient.sendRequest(reqProtocol);
        // 返回异步回调的数据
        return future.getPromise().get().getData();
    }
}

