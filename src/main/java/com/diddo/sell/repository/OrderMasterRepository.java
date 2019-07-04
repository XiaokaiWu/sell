package com.diddo.sell.repository;

import com.diddo.sell.dateobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 12:14
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
