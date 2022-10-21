package com.wy.rpc.test.extensions.robot;

import github.wy.extension.SPI;

import java.net.URL;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-15  13:16
 * @Version: 1.0.0
 * @Description: SPI测试构建类接口
 */
@SPI
public interface Robot {
    void sayHello();
}
