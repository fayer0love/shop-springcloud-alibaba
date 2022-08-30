package io.jk.shop.bean;

import com.baomidou.mybatisplus.annotation.*;
import io.jk.shop.utils.id.SnowFlakeFactory;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description OrderItem
 */
@Data
@TableName("t_order_item")
public class OrderItem implements Serializable {

    @Serial
    private static final long serialVersionUID = -1329173923755780293L;

    /**
     * Data id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @TableField(value = "id", fill = FieldFill.INSERT)
    private Long id;

    @TableField("t_order_id")
    private Long orderId;

    /**
     * Product id
     */
    @TableField("t_pro_id")
    private Long proId;

    /**
     * Product name
     */
    @TableField("t_pro_name")
    private String proName;

    /**
     * Product price (unit price)
     */
    @TableField("t_pro_price")
    private BigDecimal proPrice;

    /**
     * Purchase quantity
     */
    @TableField("t_number")
    private Integer number;

    public OrderItem(){
        this.id = SnowFlakeFactory.getSnowFlakeFromCache().nextId();
    }
}
