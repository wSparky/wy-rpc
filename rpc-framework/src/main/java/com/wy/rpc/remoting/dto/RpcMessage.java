package com.wy.rpc.remoting.dto;

import lombok.*;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-13  21:16
 * @Version: 1.0.0
 * @Description: 自定义消息类型
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcMessage {

    /**
      * rpc message type
      */
    private byte messageType;
    /**
      *serialization
      */
    private byte codec;
    /**
      *compress type
      */
    private byte compress;
    /**
      *request id
      */
    private int requestId;
    /**
      *request data
      */
    private Object data;



}
