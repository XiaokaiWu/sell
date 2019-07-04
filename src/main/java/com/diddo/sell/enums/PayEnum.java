package com.diddo.sell.enums;

import lombok.Getter;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 12:06
 */
@Getter
public enum PayEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功")
    ;

    private Integer code;
    private String msg;

    PayEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
