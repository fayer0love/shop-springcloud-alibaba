package io.jk.shop.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.jk.shop.bean.User;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description User Mapper
 *      In Interface UserMapper, nothing is defined explicitly.
 *      This is because MyBatis-Plus框架中已经封装好了针对 实体类的基础增删改查操作，
 *      而我们目前快速搭建三大微服务的过程中，使用MyBatis-Plus框架封装的
 *      基础增删改查操作就能够满足需求了。所以，在UserMapper接口中，未定义任何方法。
 */
public interface UserMapper extends BaseMapper<User> {

}
