package github.wy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-18  19:28
 * @Version: 1.0.0
 * @Description: TODO
 */
@AllArgsConstructor
@Getter
public enum RpcConfigEnum {

    RPC_CONFIG_PATH("rpc.properties"),
    ZK_ADDRESS("rpc.zookeeper.address");

    private final String propertyValue;
}
