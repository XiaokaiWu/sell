package com.diddo.sell.repository;

import com.diddo.sell.dateobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 16:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123333");
        orderDetail.setOrderId("123333");
        orderDetail.setProductId("1111111");
        orderDetail.setProductName("abc");
        orderDetail.setProductPrice(new BigDecimal(10));
        orderDetail.setProductQuantity(10);
        orderDetail.setProductIcon("http://xxx.jpg");

        repository.save(orderDetail);
    }

    @Test
    public void findByOrOrderId() {
        List<OrderDetail> byOrOrderId = repository.findByOrOrderId("123333");
        System.out.println(byOrOrderId.size());
    }
}