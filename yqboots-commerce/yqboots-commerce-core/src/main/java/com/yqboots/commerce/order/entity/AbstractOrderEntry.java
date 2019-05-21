package com.yqboots.commerce.order.entity;

import com.yqboots.commerce.product.entity.AbstractProduct;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public abstract class AbstractOrderEntry implements Serializable {
    private Integer entryNumber;
    private Double basePrice;
    private Long quantity;

    private AbstractProduct product;
    private AbstractOrder order;
}
