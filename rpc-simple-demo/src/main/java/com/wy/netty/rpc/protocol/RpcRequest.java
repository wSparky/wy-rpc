package com.wy.netty.rpc.protocol;

import lombok.Data;

import java.io.Serializable;

@Data
public class RpcRequest implements Serializable {

    private String className; //类名

    private String methodName; //请求目标方法名

    private Object[] params; //请求参数

    private Class<?>[] paramsTypes; // 参数类型
}
