package com.wy.rpc.test.extensions;

import com.wy.rpc.test.extensions.robot.Robot;
import github.wy.extension.ExtensionLoader;
import org.junit.Test;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-15  13:27
 * @Version: 1.0.0
 * @Description: Dubbo SPI学习
 */
public class DubboSPITest {

    @Test
    public void sayHello() throws Exception{
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);

        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
