package github.wy.utils;

import java.util.Collection;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-19  13:57
 * @Version: 1.0.0
 * @Description: 集合工具类
 */
public class CollectionUtil {

    public static boolean isEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }
}
