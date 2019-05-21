package com.yqboots.commerce.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public abstract class AbstractOrder implements Serializable {
    private String code;
    private OrderStatus status;
    private List<AbstractOrderEntry> entries;
    private Double totalPrice;
}
