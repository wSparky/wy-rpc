package com.wy.netty.rpc.api;

/**
 * @author wangye
 * @Email wangye.wy@outllok.com
 * @CreateTime: 2022-10-10  14:56
 * @Version: 1.0.0
 * @Description: 提供给消费端和生产者端一个可以调用的接口
 */
public interface IUserService {

   /**
     *保存用户信息
     */
    String saveUser(String name);
}
