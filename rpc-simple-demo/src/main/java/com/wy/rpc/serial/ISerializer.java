package com.wy.rpc.serial;

public interface ISerializer {

    //序列化接口
    <T> byte[] serializer(T obj);

    //返序列化接口
    <T> T deserializer(byte[] data, Class<T> clazz);

    //序列化类型
    byte getType();
}
