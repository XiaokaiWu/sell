package com.diddo.sell.enums;

import lombok.Getter;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 19:54
 */
@Getter
public enum ExceptionEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_NOT_ENOUGH(11, "库存不足");

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
