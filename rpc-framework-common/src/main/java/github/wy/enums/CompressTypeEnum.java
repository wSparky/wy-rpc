package github.wy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-14  15:20
 * @Version: 1.0.0
 * @Description: TODO
 */
@AllArgsConstructor
@Getter
public enum CompressTypeEnum {

    GZIP((byte) 0x01,"gzip");

    private final byte code;
    private final String name;

    public static String getName(byte code){
        for(CompressTypeEnum c : CompressTypeEnum.values()){
            if(c.getCode() == code){
                return c.name;
            }
        }
        return null;
    }

}
