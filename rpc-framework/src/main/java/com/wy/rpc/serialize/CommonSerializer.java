package com.wy.rpc.serialize;

import javax.sql.rowset.serial.SerialException;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-14  15:36
 * @Version: 1.0.0
 * @Description: TODO
 */

public interface CommonSerializer {

    /**
      *序列化
      */
    byte[] serialize(Object obj) throws SerialException;

    /**
      *反序列化
      */
    <T> T deserialize(byte[] bytes, Class<T> clazz);

}
