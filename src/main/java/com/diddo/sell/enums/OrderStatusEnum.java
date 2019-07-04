package com.diddo.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 12:02
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISH(1, "订单完结"),
    CANCEL(2, "已取消");

    private Integer code;
    private String mes;

    OrderStatusEnum() {
    }

    OrderStatusEnum(Integer code, String mes) {
        this.code = code;
        this.mes = mes;
    }
}
