package com.yqboots.commerce.product.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("VP")
public class VariantProduct extends AbstractProduct {
    @ManyToOne
    @JoinColumn(name = "BASE_PRODUCT")
    private Product baseProduct;
}
