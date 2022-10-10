package com.wy.netty.rpc.netty;

import com.wy.netty.rpc.netty.handler.RpcClientInitializer;
import com.wy.netty.rpc.protocol.RpcProtocol;
import com.wy.netty.rpc.protocol.RpcRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangye
 * @Email wangye.wy@outllok.com
 * @CreateTime: 2022-10-10  14:30
 * *@Version: 1.0.0
 * @Description: Netty客户端
 */
@Slf4j
public class NettyClient {

    private final Bootstrap bootstrap;

    private final EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

    private String serviceAddress;

    private int servicePort;

    public NettyClient(String serviceAddress, int servicePort){
        log.info("NettyClient is starting, address is {}, port is {}",serviceAddress,servicePort);
        bootstrap = new Bootstrap();

        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new RpcClientInitializer());

        this.serviceAddress = serviceAddress;
        this.servicePort = servicePort;
    }
    //发送数据包
    public void sendRequest(RpcProtocol<RpcRequest> protocol) throws InterruptedException{
        final ChannelFuture future = bootstrap.connect(this.serviceAddress, this.servicePort).sync();
        //监听是否连接成功
        future.addListener(listener -> {
            if (future.isSuccess()) {
                System.out.printf("connect rpc server {} success.", this.serviceAddress);
            } else {
                System.out.printf("connect rpc server {} failed. ", this.serviceAddress);
                future.cause().printStackTrace();
                eventLoopGroup.shutdownGracefully();
            }
        });
        System.out.println("begin transfer data");
        future.channel().writeAndFlush(protocol);
    }
}

