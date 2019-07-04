package com.diddo.sell.dateobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "product_info")
public class ProductInfo {

    @Id
    private String productId;

    /** 名字 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 图片 */
    private String productIcon;

    /** 状态 0正常 1下架*/
    private Integer productStatus;

    /** 商品类别编号 */
    private Integer categoryType;
}
