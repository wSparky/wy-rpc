package com.wy.rpc.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.wy.rpc.remoting.dto.RpcRequest;
import com.wy.rpc.remoting.dto.RpcResponse;
import github.wy.exception.SerializeException;
import lombok.extern.slf4j.Slf4j;

import javax.sql.rowset.serial.SerialException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-14  15:53
 * @Version: 1.0.0
 * @Description: Kryo序列化效率更高
 */
@Slf4j
public class KryoSerializer implements CommonSerializer{

    /**
      *kryo不是线程安全的，使用ThreadLocal存储Kryo对象
     */
    private final ThreadLocal<Kryo> kryoThreadLocal = ThreadLocal.withInitial(()->{
        Kryo kryo = new Kryo();
        kryo.register(RpcResponse.class);
        kryo.register(RpcRequest.class);
        return kryo;
    });

    @Override
    public byte[] serialize(Object obj){
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Output output = new Output(byteArrayOutputStream)){
            Kryo kryo = kryoThreadLocal.get();
            //序列化为byte数组
            kryo.writeObject(output,obj);
            kryoThreadLocal.remove();
            return output.toBytes();
        } catch (Exception e) {
            throw new SerializeException("Serialization failed");
        }
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            Input input = new Input(byteArrayInputStream)){
            Kryo kryo = kryoThreadLocal.get();
            //反序列化
            Object o = kryo.readObject(input,clazz);
            kryoThreadLocal.remove();
            return clazz.cast(o);
        } catch (Exception e) {
            throw new SerializeException("Deserialization failed");
        }
    }
}
