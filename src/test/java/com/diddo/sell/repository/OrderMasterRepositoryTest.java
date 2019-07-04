package com.diddo.sell.repository;

import com.diddo.sell.dateobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: wuxiaokai
 * @date: 2019-07-04 12:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private static final String openId = "110";

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12345678");
        orderMaster.setBuyerName("wuxiaokai");
        orderMaster.setBuyerPhone("15558022027");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid("110");
        orderMaster.setOrderAmount(new BigDecimal(2.1));

        repository.save(orderMaster);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid(openId, pageRequest);
        Assert.assertNotEquals(0, byBuyerOpenid.getTotalElements());
    }
}