package com.wy.rpc.codec;

import com.wy.rpc.constant.ReqType;
import com.wy.rpc.constant.RpcConstant;
import com.wy.rpc.protocol.Header;
import com.wy.rpc.protocol.RpcProtocol;
import com.wy.rpc.protocol.RpcRequest;
import com.wy.rpc.protocol.RpcResponse;
import com.wy.rpc.serial.ISerializer;
import com.wy.rpc.serial.SerializerManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class RpcDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("---------------begin RpcDecoder-------------");

        //如果接收的数据长度小于头部的总长度则直接返回
        if (in.readableBytes() < RpcConstant.HEAD_TOTAL_LEN) {
            return;
        }
        in.markReaderIndex();//从标记读取开始索引
        short magic = in.readShort();//读取魔数
        if (magic != RpcConstant.MAGIC) {
            throw new IllegalArgumentException("Illegal request parameter 'magic," + magic);

        }
        byte serialType = in.readByte(); //读取序列化类型-一个字节
        byte reqType = in.readByte(); //读取消息类型-一个字节
        long requestId = in.readLong(); //获取请求Id
        int dataLength = in.readInt(); //获取数据报文长度

        //如果接收的消息内容小于消息内容的总长度则还原数据后返回
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex(); //还原数据
            return;

        }

        //读取消息体的内容
        byte[] content = new byte[dataLength];
        in.readBytes(content);

        //根据协议类型反序列化
        Header header = new Header(magic, serialType, reqType, requestId, dataLength);
        ISerializer serializer = SerializerManager.getSerializer(serialType);//序列化类型
        ReqType rt = ReqType.findByCode(reqType);//获取请求类型

        switch (rt) {
            case REQUEST:
                //内容反序列化
                RpcRequest request = serializer.deserializer(content, RpcRequest.class);
                //返回体
                RpcProtocol<RpcRequest> reqProtocol = new RpcProtocol<>();
                reqProtocol.setHeader(header);
                reqProtocol.setContent(request);
                //传递
                out.add(reqProtocol);
                break;
            case RESPONSE:
                RpcResponse response = serializer.deserializer(content, RpcResponse.class);
                RpcProtocol<RpcResponse> resProtocol = new RpcProtocol<>();
                resProtocol.setHeader(header);
                resProtocol.setContent(response);
                out.add(resProtocol);
                break;
            case HEARTBEAT:

                break;
            default:
                break;
        }
    }
}













