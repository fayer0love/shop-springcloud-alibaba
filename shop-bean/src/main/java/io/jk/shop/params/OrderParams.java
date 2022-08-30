package io.jk.shop.params;

import lombok.Data;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description OrderParams
 */
@Data
public class OrderParams {

    /**
     * Product id
     */
    private Long productId;

    /**
     * User id
     */
    private Long userId;

    /**
     * Buy product count
     */
    private Integer count;

    public boolean isEmpty(){
        return (productId == null || productId <= 0) ||
                (userId == null || productId <= 0) ||
                (count == null || count <= 0);
    }
}
