package com.diddo.sell.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-01 22:06
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private String productDescription;

    private String productIcon;
}
