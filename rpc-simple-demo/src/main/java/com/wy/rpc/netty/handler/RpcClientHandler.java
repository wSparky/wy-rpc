package com.wy.rpc.netty.handler;

import com.wy.rpc.protocol.RequestHolder;
import com.wy.rpc.protocol.RpcFuture;
import com.wy.rpc.protocol.RpcProtocol;
import com.wy.rpc.protocol.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangye
 * @Email wangye.wy@outllok.com
 * @CreateTime: 2022-10-10  14:54
 * @Version: 1.0.0
 * @Description: TODO
 */
@Slf4j
public class RpcClientHandler extends SimpleChannelInboundHandler<RpcProtocol<RpcResponse>> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol<RpcResponse> msg) throws Exception {
        log.info("receive Rpc Server Result");
        long requestId = msg.getHeader().getRequestId();
        //根据ID获得异步对象
        RpcFuture<RpcResponse> future = RequestHolder.REQUEST_MAP.remove(requestId);
        future.getPromise().setSuccess(msg.getContent()); //返回结果

    }
}

