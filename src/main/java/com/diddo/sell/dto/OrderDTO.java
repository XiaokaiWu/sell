package com.diddo.sell.dto;

import com.diddo.sell.dateobject.OrderDetail;
import com.diddo.sell.enums.OrderStatusEnum;
import com.diddo.sell.enums.PayEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 17:03
 */
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /** 订单状态 默认为新下单 0为新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private Integer payStatus = PayEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
