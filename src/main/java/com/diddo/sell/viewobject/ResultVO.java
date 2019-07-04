package com.diddo.sell.viewobject;

import com.diddo.sell.enums.ResultEnum;
import lombok.Data;

/**
 * HTTP请求返回的最外层对象
 */
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 返回的具体内容 */
    private T data;

    public ResultVO() {}

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
