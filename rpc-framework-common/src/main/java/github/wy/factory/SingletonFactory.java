package github.wy.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-17  19:39
 * @Version: 1.0.0
 * @Description: 单列工厂，静态内部类，只有在装载Singleton以后显示调用getInstance才可以实例化Instance
 * 参考：https://www.runoob.com/design-pattern/singleton-pattern.html
 */
public class SingletonFactory {
    private static final Map<String, Object> OBJECT_MAP = new ConcurrentHashMap<>();

    private SingletonFactory() {

    }

    public static <T> T getInstance(Class<T> c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }
        String key = c.toString();
        if (OBJECT_MAP.containsKey(key)) {
            return c.cast(OBJECT_MAP.get(key));
        } else {
            return c.cast(OBJECT_MAP.computeIfAbsent(key,k->{
                try {
                    return c.getDeclaredConstructor().newInstance();
                }catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e){
                    throw new RuntimeException(e.getMessage(),e);
                }
            }));
        }
    }
}
