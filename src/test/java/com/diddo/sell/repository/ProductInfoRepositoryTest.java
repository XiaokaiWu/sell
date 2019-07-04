package com.diddo.sell.repository;

import com.diddo.sell.dateobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository infoRepository;

    @Test
    @Transactional
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setCategoryType(2);
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(10.00));
        productInfo.setProductStatus(1);
        productInfo.setProductStock(10);
        infoRepository.save(productInfo);

    }

    @Test
    public void findByProductStatus() {
        ProductInfo productInfo = new ProductInfo();
        List<ProductInfo> byProductStatus = infoRepository.findByProductStatus(1);

        for(ProductInfo info : byProductStatus) {
            System.out.println(info.getProductName());
        }
    }
}