package com.wy.netty.rpc.protocol;

import lombok.Data;

import java.io.Serializable;

@Data
public class RpcResponse implements Serializable {

    private Object data;

    private String msg;
}
