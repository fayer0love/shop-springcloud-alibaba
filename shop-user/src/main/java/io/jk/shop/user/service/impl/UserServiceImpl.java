package io.jk.shop.user.service.impl;

import io.jk.shop.bean.User;
import io.jk.shop.user.mapper.UserMapper;
import io.jk.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description User Service implementation
 *  开发业务逻辑层
 *  由于项目中使用了SpringBoot，SpringBoot又是基于Spring开发的，
 *  所以我们在项目开发过程中，都是使用Spring来管理Java对象的生命周期，
 *  也就是bean的生命周期。所以在UserServiceImpl类上标注了 @Service注解，
 *  使用@Autowired注解注入了UserMapper对象，并在getUserById()中调用
 *  UserMapper对象的selectById()方法获取用户的基本信息。
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long userId) {
        return userMapper.selectById(userId);
    }


}
