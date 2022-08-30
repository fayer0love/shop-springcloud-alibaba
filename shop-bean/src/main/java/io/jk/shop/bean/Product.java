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
 * @description Product
 */

@Data
@TableName("t_product")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = -2907409980909070073L;

    /**
     * Data id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @TableField(value = "id", fill = FieldFill.INSERT)
    private Long id;

    /**
     * Product name
     */
    @TableField("t_pro_name")
    private String proName;

    /**
     * Product price
     * */
    @TableField("t_pro_price")
    private BigDecimal proPrice;

    /**
     * Product stock
     * */
    @TableField("t_pro_stock")
    private Integer proStock;
    public Product(){
        this.id = SnowFlakeFactory.getSnowFlakeFromCache().nextId();
    }
}
