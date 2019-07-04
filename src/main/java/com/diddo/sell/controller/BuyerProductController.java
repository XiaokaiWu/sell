package com.diddo.sell.controller;

import com.diddo.sell.dateobject.ProductCategory;
import com.diddo.sell.dateobject.ProductInfo;
import com.diddo.sell.enums.ResultEnum;
import com.diddo.sell.service.CategoryService;
import com.diddo.sell.service.ProductService;
import com.diddo.sell.viewobject.ProductInfoVO;
import com.diddo.sell.viewobject.ProductVO;
import com.diddo.sell.viewobject.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@ResponseBody
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ResultVO List() {
        //1、查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2、查询类目（一次查询）
//        List<Integer> categoryList = new ArrayList<>();

//        //传统方法，for循环
//        for(ProductInfo productInfo : productInfoList){
//            categoryList.add(productInfo.getCategoryType());
//        }

        //lamda表达式
        List<Integer> categoryList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryList);

        //3、数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoList(productInfoVOList);
            productVOList.add(productVO);
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setData(productVOList);

        return resultVO;
    }
}
