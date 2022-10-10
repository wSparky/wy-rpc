package com.wy.netty.rpc.netty.handler;

import com.wy.netty.rpc.codec.RpcDecoder;
import com.wy.netty.rpc.codec.RpcEncoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class RpcServerInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new LengthFieldBasedFrameDecoder
                        (Integer.MAX_VALUE,12,4,0,0))
                .addLast(new RpcDecoder())
                .addLast(new RpcEncoder())
                .addLast(new RpcServerHandler());

    }
}
