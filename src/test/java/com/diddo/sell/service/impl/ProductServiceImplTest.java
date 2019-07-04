package com.diddo.sell.service.impl;

import com.diddo.sell.dateobject.ProductInfo;
import com.diddo.sell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findOne() {
        ProductInfo result = productService.findOne("123456");
        Assert.assertNotNull(result);
    }

    @Test
    public void findAll() {
        List<ProductInfo> result = productService.findUpAll();
        Assert.assertNotNull(result);
    }

    @Test
    public void findAll1() {
        PageRequest pageRequest = new PageRequest(0, 1);
        Page<ProductInfo> result = productService.findAll(pageRequest);

        Assert.assertNotNull(result);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setCategoryType(2);
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(10.00));
        productInfo.setProductStatus(1);
        productInfo.setProductStock(10);
        productService.save(productInfo);
    }
}