package io.jk.shop.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.jk.shop.utils.id.SnowFlakeFactory;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description Order
 */
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = -2907409980909070073L;

    /**
     * data id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @TableField(value = "id", fill = FieldFill.INSERT)
    private Long id;

    /**
     * user id
     */
    @TableField("t_user_id")
    private Long userId;

    /**
     * username
     */
    @TableField("t_user_name")
    private String username;

    /**
     * phone
     */
    @TableField("t_phone")
    private String phone;

    /**
     * address
     */
    @TableField("t_address")
    private String address;


    /**
     * total price
     */
    @TableField("t_total_price")
    private BigDecimal totalPrice;

    public Order(){
        this.id = SnowFlakeFactory.getSnowFlakeFromCache().nextId();
    }
}
