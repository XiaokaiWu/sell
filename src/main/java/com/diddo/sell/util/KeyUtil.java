package com.diddo.sell.util;

import java.util.Random;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 20:06
 */
public class KeyUtil {
    /**
     * 生成id策略   时间 + 随机数
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
