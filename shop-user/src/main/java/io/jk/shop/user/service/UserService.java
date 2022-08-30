package io.jk.shop.user.service;

import io.jk.shop.bean.User;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description User Service Interface
 *  开发业务逻辑层
 *  用户微服务的业务逻辑层主要提供针对用户信息的业务逻辑开发
 */
public interface UserService {

    /**
     * Get user by ID
     */
    User getUserById(Long userId);
}
