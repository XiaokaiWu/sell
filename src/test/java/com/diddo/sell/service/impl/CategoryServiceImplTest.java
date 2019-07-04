package com.diddo.sell.service.impl;

import com.diddo.sell.dateobject.ProductCategory;
import com.diddo.sell.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findOne() {
        ProductCategory one = categoryService.findOne(10);
        Assert.assertNotNull(one);
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = categoryService.findAll();
        Assert.assertNotNull(all);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(2, 3, 2);
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(list);
        for(ProductCategory productCategory : categoryList) {
            System.out.println(productCategory.getCategoryType());
        }
    }

    @Test
    @Transactional
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(4);
        productCategory.setCategoryName("宠物专栏");
        categoryService.save(productCategory);
    }
}