package github.wy.exception;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-14  16:28
 * @Version: 1.0.0
 * @Description: 序列化错误类型
 */
public class SerializeException extends RuntimeException{
    public SerializeException(String message){
        super(message);
    }
}
