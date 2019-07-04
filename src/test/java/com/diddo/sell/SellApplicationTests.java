package com.diddo.sell;

import com.diddo.sell.dateobject.ProductCategory;
import com.diddo.sell.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellApplicationTests {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOne() {
        List<ProductCategory> all = productCategoryRepository.findAll();
        for (ProductCategory category:
             all) {
            System.out.println(category.getCategoryId());
        }
    }

    @Test
    public void saveOne() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(2);
        ProductCategory save = productCategoryRepository.save(productCategory);
    }

    @Test
    public void updateOne(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(2);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void saveNext() {
        ProductCategory productCategory = new ProductCategory("女生最爱", 3);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryType (){
        List<Integer> categoryTypeList = Arrays.asList(1, 2, 3);
        List<ProductCategory> resultList = productCategoryRepository.findByCategoryTypeIn(categoryTypeList);

        for(ProductCategory temp : resultList) {
            System.out.println(temp.getCategoryName());
        }
    }

}
