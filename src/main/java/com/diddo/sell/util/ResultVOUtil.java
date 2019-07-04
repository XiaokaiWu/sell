package com.diddo.sell.util;

import com.diddo.sell.enums.ResultEnum;
import com.diddo.sell.viewobject.ResultVO;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 11:23
 */
public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultEnum.SUCCESS.getMessage());
        return resultVo;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
