package io.jk.shop.bean;

import com.baomidou.mybatisplus.annotation.*;
import io.jk.shop.utils.id.SnowFlakeFactory;
import io.jk.shop.utils.psswd.PasswordUtils;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description User
 */
@Data
@TableName("t_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -7032479567987350240L;

    /**
     * Data id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @TableField(value = "id", fill = FieldFill.INSERT)
    private Long id;

    /**
     * User name
     */
    @TableField(value = "t_username")
    private String username;

    /**
     * User password
     */
    @TableField(value = "t_password")
    private String password;

    /**
     * User phone
     */
    @TableField(value = "t_phone")
    private String phone;

    /**
     * User address
     */
    @TableField(value = "t_address")
    private String address;

    public User() {
        this.id = SnowFlakeFactory.getSnowFlakeFromCache().nextId();
        // default password
        this.password = PasswordUtils.getPassword("123456");
    }

}
