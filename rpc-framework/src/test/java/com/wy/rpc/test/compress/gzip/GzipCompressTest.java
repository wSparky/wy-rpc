package com.wy.rpc.test.compress.gzip;

import com.wy.rpc.compress.Compress;
import com.wy.rpc.compress.gzip.GzipCompress;
import com.wy.rpc.remoting.dto.RpcRequest;
import com.wy.rpc.serialize.KryoSerializer;
import org.junit.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-22  09:38
 * @Version: 1.0.0
 * @Description: 压缩算法测试,使用了assertEquals
 * 参考：https://blog.csdn.net/tgvincent/article/details/81296349
 */
public class GzipCompressTest {
    @Test
    public void gzipCompressTest(){
        Compress gzipCompress = new GzipCompress();
        RpcRequest rpcRequest = RpcRequest.builder()
                .methodName("hello")
                .parameters(new Object[]{"sayHello","sayHi"})
                .interfaceName("com.wy.rpc.HelloService")
                .paramTypes(new Class<?>[]{String.class,String.class})
                .requestId(UUID.randomUUID().toString())
                .group("group1")
                .version("version1")
                .build();

        KryoSerializer kryoSerializer = new KryoSerializer();
        byte[] rpcRequestBytes = kryoSerializer.serialize(rpcRequest);
        byte[] compressRpcRequestBytes = gzipCompress.compress(rpcRequestBytes);
        byte[] decompressRpcRequestBytes = gzipCompress.decompress(compressRpcRequestBytes);
        assertEquals(rpcRequestBytes.length, decompressRpcRequestBytes.length);
    }
}
