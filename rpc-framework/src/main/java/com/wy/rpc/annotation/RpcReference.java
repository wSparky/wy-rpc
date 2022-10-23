package com.wy.rpc.annotation;

import java.lang.annotation.*;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-22  10:39
 * @Version: 1.0.0
 * @Description: TODO
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface RpcReference {

    String group() default "";

    String version() default "";
}
