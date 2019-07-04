package com.diddo.sell.dateobject;

import com.diddo.sell.enums.OrderStatusEnum;
import com.diddo.sell.enums.PayEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 11:59
 */
@Entity
@Data
@Table(name = "order_master")
@DynamicInsert
@DynamicUpdate
public class OrderMaster {

    @Id
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

}
