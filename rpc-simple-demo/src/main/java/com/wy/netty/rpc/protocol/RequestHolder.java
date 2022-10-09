package com.wy.netty.rpc.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RequestHolder {

    /**
     *原子性请求Id
     */
    public static final AtomicLong REQUEST_ID = new AtomicLong();

    /**
     *
     *保存请求ID和返回数据的关系
     */
    public static final Map<Long,RpcFuture> RPC_MAP = new ConcurrentHashMap<>();


}
