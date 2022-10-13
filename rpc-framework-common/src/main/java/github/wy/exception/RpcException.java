package github.wy.exception;

import github.wy.enums.RpcErrorMessageEnum;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-13  14:55
 * @Version: 1.0.0
 * @Description: Rpc报错类型,对异常处理有疑惑可以借鉴我的个人总结：https://www.cnblogs.com/whuohua/articles/16789261.html
 */
public class RpcException extends RuntimeException{

    public RpcException(RpcErrorMessageEnum rpcErrorMessageEnum, String detail){
        super(rpcErrorMessageEnum.getMessage() + ":" + detail);
    }

    public RpcException(String message,Throwable cause){
        super(message,cause);
    }

    public RpcException(RpcErrorMessageEnum rpcErrorMessageEnum){
        super(rpcErrorMessageEnum.getMessage());
    }
}
