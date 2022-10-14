package github.wy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-14  16:43
 * @Version: 1.0.0
 * @Description: TODO
 */
@AllArgsConstructor
@Getter
public enum SerializationTypeEnum {

    KRYO((byte) 0x01, "kryo"),
    PROTOSTUFF((byte) 0x02, "protostuff"),
    HESSIAN((byte) 0X03, "hessian");

    private final byte code;
    private final String name;

    public static String getName(byte code){
        for(SerializationTypeEnum c : SerializationTypeEnum.values()){
            if(c.getCode() == code){
                return c.name;
            }
        }
        return null;
    }
}
