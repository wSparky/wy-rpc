package com.wy.netty.rpc.codec;

import com.wy.netty.rpc.protocol.Header;
import com.wy.netty.rpc.protocol.RpcProtocol;
import com.wy.netty.rpc.serial.ISerializer;
import com.wy.netty.rpc.serial.SerializerManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class RpcEncoder extends MessageToByteEncoder<RpcProtocol<Object>> {
    @Override
    protected void encode(ChannelHandlerContext ctx, RpcProtocol<Object> msg, ByteBuf out) throws Exception {
        System.out.println("============begin RpcEncoder=========");
        Header header = msg.getHeader();
        out.writeShort(header.getMagic());
        out.writeByte(header.getSerialType());
        out.writeByte(header.getReqType());
        out.writeLong(header.getRequestId());
        // 序列化内容
        ISerializer serializer = SerializerManager.getSerializer(header.getSerialType());
        byte[] data = serializer.serializer(msg.getContent());
        out.writeInt(data.length);
        out.writeBytes(data);
    }
}

