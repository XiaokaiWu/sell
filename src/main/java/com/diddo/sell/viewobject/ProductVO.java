package com.diddo.sell.viewobject;

import com.diddo.sell.dateobject.ProductInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @description:商品VO类
 * @author: wuxiaokai
 * @date: 2019-07-01 22:00
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoList;
}
