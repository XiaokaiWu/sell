package com.diddo.sell.service.impl;

import com.diddo.sell.dateobject.OrderDetail;
import com.diddo.sell.dateobject.OrderMaster;
import com.diddo.sell.dateobject.ProductInfo;
import com.diddo.sell.dto.CartDTO;
import com.diddo.sell.dto.OrderDTO;
import com.diddo.sell.enums.ExceptionEnum;
import com.diddo.sell.exception.SellException;
import com.diddo.sell.repository.OrderDetailRepository;
import com.diddo.sell.repository.OrderMasterRepository;
import com.diddo.sell.service.OrderService;
import com.diddo.sell.service.ProductService;
import com.diddo.sell.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:orderService实现类
 * @author: wuxiaokai
 * @date: 2019-07-04 17:23
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        String orderId = KeyUtil.getUniqueKey();
        //1、查询商品（数量价格）
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        for(OrderDetail orderDetail : orderDetailList){
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if(productInfo == null){
                throw new SellException(ExceptionEnum.PRODUCT_NOT_EXIST);
            }

            //计算订单总价
            orderAmount = orderDetail.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //订单详情入库,1、生成订单id 2、生成主键id
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);

            orderDetailRepository.save(orderDetail);
        }

        //3、写入订单数据库（orderMaster，orderDetail）
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO, orderMaster);

        orderMasterRepository.save(orderMaster);

        //4、扣库存
        List<CartDTO> cartDTOList = new ArrayList<>();

        orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());

        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancelOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finishOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
