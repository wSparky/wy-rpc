package com.wy.netty.rpc.netty.handler;

import com.wy.netty.rpc.codec.RpcDecoder;
import com.wy.netty.rpc.codec.RpcEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangye
 * @Email wangye.wy@outllok.com
 * @CreateTime: 2022-10-10  14:49
 * @Version: 1.0.0
 * @Description: TODO
 */
@Slf4j
public class RpcClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        log.info("RpcClientInitializer is starting ");
        ch.pipeline().addLast(
                new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,
                        12,
                        4,
                        0, 0))
                .addLast(new LoggingHandler()) // 日志处理
                .addLast(new RpcEncoder())
                .addLast(new RpcDecoder())
                .addLast(new RpcClientHandler());
    }
}
