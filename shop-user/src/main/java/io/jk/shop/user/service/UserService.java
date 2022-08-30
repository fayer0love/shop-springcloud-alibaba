package io.jk.shop.user.service;

import io.jk.shop.bean.User;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description User Service Interface
 */
public interface UserService {

    /**
     * Get user by ID
     */
    User getUserById(Long userId);
}
