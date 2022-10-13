package github.wy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-13  18:39
 * @Version: 1.0.0
 * @Description: TODO
 */
@AllArgsConstructor
@Getter
@ToString
public enum RpcResponseCodeEnum {

    SUCCESS(200,"The remote call is successful"),
    FAIL(500,"The remote call is fail");

    private final int code;
    private final String message;
}
