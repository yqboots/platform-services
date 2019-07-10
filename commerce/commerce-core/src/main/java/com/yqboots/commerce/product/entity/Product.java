package com.yqboots.commerce.product.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("P")
public class Product extends AbstractProduct {
    @OneToMany(mappedBy = "baseProduct")
    private List<VariantProduct> variants;
}
