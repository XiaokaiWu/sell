package com.diddo.sell.repository;

import com.diddo.sell.dateobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 12:17
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrOrderId(String orderId);
}
