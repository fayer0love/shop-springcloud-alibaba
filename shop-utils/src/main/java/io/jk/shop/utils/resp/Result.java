package io.jk.shop.utils.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description response result
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1497405107265595284L;

    /**
     * status code
     */
    private Integer code;

    /**
     * status description
     */
    private String codeMsg;

    /**
     * return data
     */
    private T data;
}
