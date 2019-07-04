package com.diddo.sell.exception;

import com.diddo.sell.enums.ExceptionEnum;
import com.diddo.sell.enums.ResultEnum;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 11:27
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ExceptionEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }
}
