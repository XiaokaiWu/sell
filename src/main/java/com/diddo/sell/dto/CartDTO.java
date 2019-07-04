package com.diddo.sell.dto;

import lombok.Data;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 20:16
 */
@Data
public class CartDTO {
    /** 商品id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
