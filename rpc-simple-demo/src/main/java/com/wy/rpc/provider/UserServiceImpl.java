package com.wy.rpc.provider;

import com.wy.rpc.api.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author wangye
 * @Email wangye.wy@outllok.com
 * @CreateTime: 2022-10-10  15:09
 * @Version: 1.0.0
 * @Description: 服务实现类
 */

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public String saveUser(String name) {
        System.out.println("user: " +name);

        return "save user success：" + name;
    }
}
