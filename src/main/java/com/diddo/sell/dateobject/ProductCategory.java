package com.diddo.sell.dateobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 类目
 * @DynamicUpdate可以自动更新时间，就是查出来之后再存进去可以自己更新时间
 */
@Entity
@Table(name = "product_category")
@DynamicUpdate
@Data
public class ProductCategory {

    /** 类目ID */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }
}
