package com.wy.netty.rpc.provider;

import com.wy.netty.rpc.api.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author wangye
 * @Email wangye.wy@outllok.com
 * @CreateTime: 2022-10-10  15:09
 * @Version: 1.0.0
 * @Description: TODO
 */

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public String saveUser(String name) {
        System.out.println("user: " +name);

        return "save user success：" + name;
    }
}
