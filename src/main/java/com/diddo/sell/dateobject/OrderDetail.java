package com.diddo.sell.dateobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 12:10
 */
@Entity
@Data
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    private String detailId;

    /** 订单ID */
    private String orderId;

    private String productId;

    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 商品数量 */
    private Integer productQuantity;

    /** 商品小图 */
    private String productIcon;
}
