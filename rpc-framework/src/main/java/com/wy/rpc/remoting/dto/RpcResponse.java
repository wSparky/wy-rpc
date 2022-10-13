package com.wy.rpc.remoting.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-13  21:38
 * @Version: 1.0.0
 * @Description: Rpc响应实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class RpcResponse<T> implements Serializable {
    public static final long serialVersionUID = 715745410605631233L;
    private String requestId;
    /**
      *response code
      */
    private Integer code;
    /**
      *response message
      */
    private String message;
    /**
      *response message
      */
    private T data;






}
