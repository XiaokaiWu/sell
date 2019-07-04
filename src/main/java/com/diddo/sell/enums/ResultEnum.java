package com.diddo.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-01 22:12
 */
@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    FAIL(1, "失败");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
