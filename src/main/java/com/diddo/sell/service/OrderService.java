package com.diddo.sell.service;

import com.diddo.sell.dateobject.OrderMaster;
import com.diddo.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 16:54
 */
public interface OrderService {

    /** 创建订单 */
    OrderDTO createOrder(OrderDTO orderDTO);

    /** 查询单个订单 */
    OrderDTO findOne(String orderId);

    /** 查询订单列表 */
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    /** 取消订单 */
    OrderDTO cancelOrder(OrderDTO orderDTO);

    /** 完结订单 */
    OrderDTO finishOrder(OrderDTO orderDTO);

    /** 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);
}
