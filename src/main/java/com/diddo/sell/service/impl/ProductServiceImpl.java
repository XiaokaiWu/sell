package com.diddo.sell.service.impl;

import com.diddo.sell.dateobject.ProductInfo;
import com.diddo.sell.dto.CartDTO;
import com.diddo.sell.enums.ExceptionEnum;
import com.diddo.sell.enums.ProductStatusEnum;
import com.diddo.sell.exception.SellException;
import com.diddo.sell.repository.ProductInfoRepository;
import com.diddo.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository infoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return infoRepository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return infoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return infoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return infoRepository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = infoRepository.findById(cartDTO.getProductId()).get();
            if(productInfo == null) {
                throw new SellException(ExceptionEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0) {
                throw new SellException(ExceptionEnum.PRODUCT_STOCK_NOT_ENOUGH);
            }
            productInfo.setProductStock(result);

            infoRepository.save(productInfo);
        }
    }
}
