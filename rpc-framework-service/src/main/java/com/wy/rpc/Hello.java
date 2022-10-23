package com.wy.rpc;

import lombok.*;

import java.io.Serializable;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-22  09:47
 * @Version: 1.0.0
 * @Description: 服务实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Hello implements Serializable {
    private String message;
    private String description;
}
