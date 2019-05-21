package com.yqboots.commerce.product.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class AbstractProduct {
    private String code;
    private String name;
    private String description;
}
