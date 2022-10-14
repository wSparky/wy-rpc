package github.wy.extension;

import java.lang.annotation.*;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-14  19:54
 * @Version: 1.0.0
 * @Description: SPI机制，此处采用的是Dubbo的SPI机制
 * 参考：JAVA中的SPI机制：https://zhuanlan.zhihu.com/p/84337883
 *      Dubbo中的SPI机制：https://tianxiaobo.com/2018/10/01/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-SPI-%E6%9C%BA%E5%88%B6/
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface SPI {
}
