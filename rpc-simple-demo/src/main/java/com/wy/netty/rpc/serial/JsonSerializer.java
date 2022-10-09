package com.wy.netty.rpc.serial;

import com.wy.netty.rpc.constant.SerialType;
import com.alibaba.fastjson.JSON;
import java.nio.charset.StandardCharsets;

public class JsonSerializer implements ISerializer {

    @Override
    public <T> byte[] serializer(T obj) {
        return JSON.toJSONString(obj).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public <T> T deserializer(byte[] data, Class<T> clazz) {
        return JSON.parseObject(new String(data), clazz);
    }

    @Override
    public byte getType() {
        return SerialType.JSON_SERIAL.code();
    }
}

