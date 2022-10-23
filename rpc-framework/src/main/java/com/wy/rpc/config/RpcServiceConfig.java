package com.wy.rpc.config;

import lombok.*;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-16  12:55
 * @Version: 1.0.0
 * @Description: Rpc服务基本结构
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcServiceConfig {
    /**
     *service version
     */

    private String version = "";

    /**
     *实现类所属group
     */

    private String group = "";

    /**
     *target service
     */
    private Object service;

    public String getRpcServiceName(){
        return this.getServiceName()+this.getGroup()+this.getVersion();
    }
    public String getServiceName(){
        return this.service.getClass().getInterfaces()[0].getCanonicalName();
    }
    }





