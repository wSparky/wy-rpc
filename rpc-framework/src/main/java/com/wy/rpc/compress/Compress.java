package com.wy.rpc.compress;

import github.wy.extension.SPI;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-15  14:49
 * @Version: 1.0.0
 * @Description: TODO
 */

@SPI
public interface Compress {

    byte[] compress(byte[] bytes);

    byte[] decompress(byte[] bytes);
}
